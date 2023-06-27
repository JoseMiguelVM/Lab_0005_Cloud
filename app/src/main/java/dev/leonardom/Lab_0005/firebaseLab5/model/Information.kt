package dev.leonardom.Lab_0005.firebaseLab5.model

class Information (
    val id: String,
    val fecha: String,
    val temperatura: String,
    val comentario: String
    ){
    constructor(): this("", "", "", "")
}