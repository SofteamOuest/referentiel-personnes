package com.softeam.referentielpersonnes.configuration

import com.mongodb.Mongo
import com.mongodb.MongoClient
import org.mongeez.Mongeez
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.mongo.MongoProperties
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoConfiguration
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.context.annotation.Bean
import org.springframework.core.io.ClassPathResource
import org.springframework.data.mongodb.core.SimpleMongoDbFactory
import org.springframework.data.mongodb.MongoDbFactory


@Configuration
open class MongoConfiguration : AbstractMongoConfiguration() {

    @Value("\${spring.application.data.mongodb.url}")
    lateinit var mongoUrl : String

    @Bean
    override fun mongo(): Mongo {
        return mongoClient()
    }

    @Bean
    override fun getDatabaseName(): String {
        return "db"
    }

    @Bean
    @Throws(Exception::class)
    open fun mongoClient(): MongoClient {
        val mongoClient = MongoClient(mongoUrl)
        return mongoClient
    }

    @Bean
    open fun init(): Mongeez {
        val mongeez = Mongeez()
        mongeez.setFile(ClassPathResource("/db/mongeez.xml"))
        mongeez.setMongo(mongo())
        mongeez.setDbName("db")
        mongeez.process()
        return mongeez
    }

    @Bean
    @Throws(Exception::class)
    override open fun mongoTemplate(): MongoTemplate {
        init()
        return MongoTemplate(mongoClient(), getDatabaseName())
    }
}
