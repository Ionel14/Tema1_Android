package com.example.animals.models

enum class Continent(val key: Int) {
    Europe(0),
    Africa(1),
    Asia(2),
    America(3),
    Australia(4)
}

class Animal (val name:String, val continent: Continent)