package com.example.server.controller

import com.example.server.data.Book
import com.example.server.data.Phone
import com.example.server.data.Unbook
import com.example.server.service.PhoneService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PhoneResource(val service: PhoneService) {
    @GetMapping("/")
    fun index(): List<Phone> = service.getAll()

    @PostMapping
    fun save(@RequestBody phone: Phone) = service.save(phone)

    @PostMapping("/book")
    fun book(@RequestBody book: Book) = service.book(book.id, book.name)

    @PostMapping("/unbook")
    fun unbook(@RequestBody unbook: Unbook) = service.unbook(unbook.id)

    @GetMapping("/available")
    fun available(): List<Phone> = service.getAllAvailable()

    @GetMapping("/unavailable")
    fun unavailable(): List<Phone> = service.getAllUnavailable()

}