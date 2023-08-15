package com.baangn

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
class ServerKtApplication

fun main(args: Array<String>) {
    runApplication<ServerKtApplication>(*args)
}