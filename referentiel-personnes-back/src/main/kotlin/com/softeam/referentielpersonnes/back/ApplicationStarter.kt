package com.softeam.referentielpersonnes.back

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.support.SpringBootServletInitializer

@SpringBootApplication
open class ApplicationStarter : SpringBootServletInitializer()

fun main(args: Array<String>) {
    SpringApplication.run(ApplicationStarter::class.java, *args)
}