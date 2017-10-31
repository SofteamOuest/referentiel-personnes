package com.softeam.referentielpersonnes.configuration

import com.mongodb.MongoClient
import org.mongeez.Mongeez
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.core.io.ClassPathResource
import com.dropbox.core.v2.DbxClientV2
import com.dropbox.core.DbxRequestConfig
import com.dropbox.core.v2.DbxClientV2Base
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import com.dropbox.core.v2.users.FullAccount




@Configuration
open class DropboxConfiguration {


    @Bean
    open fun dbxClientV2(@Value("\${dropbox.token}") accessToken : String) : DbxClientV2Base {
        val config = DbxRequestConfig("referentiel-personnes-api", "fr_FR")
        val client = DbxClientV2(config, accessToken)
        val account = client.users().currentAccount
        println(account.name.displayName)
        return client
    }



}