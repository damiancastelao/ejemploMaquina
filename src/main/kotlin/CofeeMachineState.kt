package org.example

/**
 * Clase sellada que representa los diferentes estados de la máquina de café
 */
sealed class CoffeeMachineState {
    data class Idle(val monedero: Int = 0) : CoffeeMachineState() {
        fun onEnter() {
            println("Entrando al estado Idle")
        }
    }
    data class MakingCoffee(val type: Bebidas) : CoffeeMachineState(){
        fun onEnter() {
            println("Entrando al estado MakingCoffee, haciendo $type")
            Thread.sleep(5000) // termino de preparar el café
        }
    }
    data class ServingCoffee(val type: Bebidas) : CoffeeMachineState() {
        fun onEnter() {
            println("Entrando al estado ServingCoffee, sirviendo $type")
            Thread.sleep(5000) // termino de preparar el café
        }
    }
    data class Error(val message: String) : CoffeeMachineState(){
        fun onEnter() {
            println("Entrando al estado Error: $message")
        }
    }
}

