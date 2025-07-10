package com.passkeys

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PasskeysApplication

fun main(args: Array<String>) {
    runApplication<PasskeysApplication>(*args)
}
