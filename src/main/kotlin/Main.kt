package org.example

fun main() {

    // Simula la inserción de dinero en la máquina
    CoffeeMachine.monedero = 1

    println("---- Primera llamada ----")
    CoffeeMachine.gestorEstados()

    // Simula la eleccion de tipo de café
    CoffeeMachine.seleccion = Bebidas.AMERICANO
    println("---- Segunda llamada ----")
    CoffeeMachine.gestorEstados()
    println("---- Tercera llamada ----")
    CoffeeMachine.gestorEstados()

}