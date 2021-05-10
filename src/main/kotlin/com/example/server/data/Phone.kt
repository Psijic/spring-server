package com.example.server.data

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("PHONES")
data class Phone(@Id val id: String?,
                 val technology: String,
                 val band_2g: Boolean,
                 val band_3g: Boolean,
                 val band_4g: Boolean,
                 val booked_date: Date?,
                 val booked_by: String?
)