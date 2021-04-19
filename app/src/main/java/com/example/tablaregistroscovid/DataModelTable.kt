package com.example.tablaregistroscovid

data class DataModelTable(
    val idPerson: Int?,
    val firstName: String,
    val state: EState,
    val picture: Int,
    val lastName: String,
    val sex: ESex,
    val age: Int,
    val date: String
)

enum class EState{ SANO, VACUNADO, CONTAGIADO }

enum class ESex{ FEMENINO, MASCULINO }

