package com.example.server.repository

import com.example.server.data.Phone
import org.springframework.data.jdbc.repository.query.Modifying
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional
import java.util.*

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