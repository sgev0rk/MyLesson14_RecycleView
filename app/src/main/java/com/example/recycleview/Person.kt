package com.example.recycleview

class Person(
    val name: String,
    val age: Int,
    val mother: Person? = null,
    val father: Person? = null
)