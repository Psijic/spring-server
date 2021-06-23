package com.example.server.service

import com.example.server.data.Phone
import com.example.server.repository.PhoneRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class PhoneService(val db: PhoneRepository) {

    fun getAll(): List<Phone> = db.getAll()

    fun save(phone: Phone) {
        db.save(phone)
    }

    fun isBooked(id: String): Boolean {
        return db.checkIsBooked(id) != null
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