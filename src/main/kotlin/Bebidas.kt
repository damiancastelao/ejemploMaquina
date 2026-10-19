package org.example

/**
 * Enum que representa las bebidas disponibles en la máquina de café
 */
enum class Bebidas(val nombre: String, val precio: Double, unidades: Int = 10) {
    CAPUCCINO("Capuccino", 3.5),
    LATA("Lata", 2.0),
    AMERICANO("Americano", 1.5)
}