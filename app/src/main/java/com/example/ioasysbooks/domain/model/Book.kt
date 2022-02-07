package com.example.ioasysbooks.domain.model

data class Book(
    val id: String,
    val name: String,
    val author: String = "Geoffrey A. Moore",
    val pages: String = "150 Páginas",
    val editor: String = "Editora Loyola",
    val date: String = "Publicado em 2020",
    val isbn10: String = "0062856626",
    val isbn13: String = "978-0062856623",
    val language: String = "Inglês",
    val originName: String = "Change By Design",
    val review: String = "The subject of “design thinking” is the rage at business schools, throughout corporations, and increasingly in the popular press—due in large part to the work of IDEO, a leading design firm, and its celebrated CEO, Tim Brown, who uses this book to show how the techniques and strategies of design belong at every level.",
    val imageUrl: String = ""
)