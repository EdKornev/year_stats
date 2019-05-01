package com.edkornev.yearstats.domain

import java.util.*

class BookModel(
    var title: String = "",
    var author: String = "",
    var genre: String = "",
    var readedAt: Date = Date(),
    var createdAt: Date = Date(),
    val updatedAt: Date = Date()
)