package com.example.api.bookstore.domain.db

import com.example.util.exposed.instant
import org.jetbrains.exposed.sql.Table

object AuthorTable : Table("author") {
    val id = uuid("id").primaryKey()
    val createdAt = instant("created_at")
    val modifiedAt = instant("updated_at")
    val version = integer("version")
    val name = text("name")
}

object BookTable : Table("book") {
    val id = uuid("id").primaryKey()
    val createdAt = instant("created_at")
    val modifiedAt = instant("updated_at")
    val version = integer("version")
    val authorId = (uuid("author_id") references AuthorTable.id)
    val title = varchar("title", 255)
    val status = enumerationByName("status", 255, BookStatus::class.java)
}

enum class BookStatus { NEW, PUBLISHED; }
