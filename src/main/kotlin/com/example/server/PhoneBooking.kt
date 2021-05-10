package com.example.server

import com.example.server.data.Book
import com.example.server.data.Phone
import com.example.server.data.Unbook
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jdbc.repository.query.Modifying
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import java.util.*


@SpringBootApplication
class PhoneBooking

fun main(args: Array<String>) {
    runApplication<PhoneBooking>(*args)
}

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

@Service
class PhoneService(val db: PhoneRepository) {

    fun getAll(): List<Phone> = db.getAll()

    fun save(phone: Phone) {
        db.save(phone)
    }

    fun book(id: String, name: String) {
        db.book(id, name, Date())
    }

    fun unbook(id: String) {
        db.unbook(id)
    }

    fun getAllAvailable(): List<Phone> = db.getAllAvailable()

    fun getAllUnavailable(): List<Phone> = db.getAllUnavailable()
}


interface PhoneRepository : CrudRepository<Phone, String> {
    @Query("SELECT * FROM phones")
    fun getAll(): List<Phone>

    @Query("SELECT * FROM phones WHERE booked_date IS NULL")
    fun getAllAvailable(): List<Phone>

    @Query("SELECT * FROM phones WHERE booked_date IS NOT NULL")
    fun getAllUnavailable(): List<Phone>

    @Transactional
    @Modifying
    @Query("UPDATE phones p set booked_by =:name, booked_date =:date WHERE p.id = :id")
    fun book(@Param("id") id: String, @Param("name") name: String, @Param("date") date: Date)

    @Transactional
    @Modifying
    @Query("UPDATE phones p set booked_by = NULL, booked_date = NULL WHERE p.id = :id")
    fun unbook(@Param("id") id: String)
}