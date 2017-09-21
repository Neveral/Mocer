package com.neveral.mocer

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class MocerApplication

fun main(args: Array<String>) {
    SpringApplication.run(MocerApplication::class.java, *args)
}
