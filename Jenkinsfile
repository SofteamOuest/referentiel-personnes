#!groovy
import java.text.SimpleDateFormat

// pod utilisé pour la compilation du projet
podTemplate(label: 'meltingpoc-build-pod', nodeSelector: 'medium', containers: [

        // le slave jenkins
        containerTemplate(name: 'jnlp', image: 'jenkinsci/jnlp-slave:alpine'),

        // un conteneur pour le build maven
        containerTemplate(name: 'gradle', image: 'elkouhen/gradle-docker', privileged: true, ttyEnabled: true, command: 'cat'),

        // un conteneur pour construire les images docker
        containerTemplate(name: 'docker', image: 'docker', command: 'cat', ttyEnabled: true),

        // un conteneur pour déployer les services kubernetes
        containerTemplate(name: 'kubectl', image: 'lachlanevenson/k8s-kubectl', command: 'cat', ttyEnabled: true)],

        // montage nécessaire pour que le conteneur docker fonction (Docker In Docker)
        volumes: [hostPathVolume(hostPath: '/var/run/docker.sock', mountPath: '/var/run/docker.sock')]
) {

    node('meltingpoc-build-pod') {

        def branch = env.JOB_NAME.replaceFirst('.+/', '');

        stage('checkout sources'){
            checkout scm;
        }

        container('gradle') {

                stage('build sources'){
                    sh 'cd referentiel-personnes-back; gradle clean build'
                }
        }

        container('docker') {

                stage('build docker image'){


                    sh 'ls -la referentiel-personnes-back/build/libs'

                    sh 'cd referentiel-personnes-back; docker build -t registry.wildwidewest.xyz/repository/docker-repository/pocs/meltingpoc .'

                    sh 'mkdir /etc/docker'

                    // le registry est insecure (pas de https)
                    sh 'echo {"insecure-registries" : ["registry.wildwidewest.xyz"]} > /etc/docker/daemon.json'

                    withCredentials([string(credentialsId: 'nexus_password', variable: 'NEXUS_PWD')]) {
                         echo "My password is '${NEXUS_PWD}'!"
                    }

                    sh 'docker login -u admin -p softeam44 registry.wildwidewest.xyz'

                    sh 'docker push registry.wildwidewest.xyz/repository/docker-repository/pocs/meltingpoc'
                }
        }

        container('kubectl') {

            stage('deploy'){

                sh 'kubectl delete ing meltingpoc'
                sh 'kubectl delete svc meltingpoc'
                sh 'kubectl delete deployment meltingpoc'
                sh 'kubectl apply -f kubernetes/meltingpoc.yml'

            }
        }
    }
}
