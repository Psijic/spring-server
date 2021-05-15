package com.example.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class PhoneBooking

fun main(args: Array<String>) {
    runApplication<PhoneBooking>(*args)
}