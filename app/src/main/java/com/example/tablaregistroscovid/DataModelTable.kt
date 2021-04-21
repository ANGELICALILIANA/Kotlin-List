package com.example.tablaregistroscovid

/**
 * Clase para el modelo de datos requerido
 */
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

/**
 * Clase que especifica los únicos datos permitidos para el estado de la persona
 */
enum class EState{ SANO, VACUNADO, CONTAGIADO }

/**
 * Clase que especifica los únicos datos permitidos para el sexo de la persona
 */
enum class ESex{ FEMENINO, MASCULINO }

