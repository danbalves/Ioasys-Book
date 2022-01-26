package com.example.ioasysbooks.models

data class Book(
    val id: Int,
    val title: String,
    val author: String = "Geoffrey A. Moore",
    val pageCount: String = "Páginas ",
    val publisher: String = "Editora ",
    val published: String = "Publicado em "
){
    companion object {
        fun getMockList() = listOf(

            Book(
                id = 1,
                title = "Crossing the Chass"
            ),

            Book(
                id = 2,
                title = "Change By Design"
            ),

            Book(
                id = 3,
                title = "The Making of a Manager"
            ),

            Book(
                id = 4,
                title = "Don't Make me Think"
            ),

            Book(
                id = 5,
                title = "Web Design 161"
            )
        )

        fun getMockListCount(count: Int): List<Book> {
            val mockList = mutableListOf<Book>()
            for(id in 1..count){
                mockList.add(
                    Book(
                        id = id,
                        title = "Crossing The Charm"
                    )
                )
            }
            return mockList
        }
    }
}