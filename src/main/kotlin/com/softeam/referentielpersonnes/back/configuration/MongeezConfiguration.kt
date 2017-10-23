package com.softeam.referentielpersonnes.back.configuration

import com.mongodb.MongoClient
import org.mongeez.Mongeez
import org.springframework.core.io.ClassPathResource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


//@Configuration
open class MongeezConfiguration {

    @Autowired
    lateinit var mongo : MongoClient;

    @Bean
    open fun init() : Mongeez{
        val mongeez = Mongeez()
        mongeez.setFile(ClassPathResource("/db/mongeez.xml"))
        mongeez.setMongo(mongo)
        mongeez.setDbName("db")
        mongeez.process()
        return mongeez
    }



}