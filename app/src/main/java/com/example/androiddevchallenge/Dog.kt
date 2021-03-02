package com.example.androiddevchallenge

import java.io.Serializable
import java.util.*

data class Dog( val breed:String, val id:String= breed, val details:String = "This is a $breed type dog.") :Serializable
