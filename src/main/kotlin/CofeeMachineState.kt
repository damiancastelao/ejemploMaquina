package org.example

import org.example.CoffeeMachine.currentState
import org.example.CoffeeMachine.seleccion

/**
 * Clase sellada que representa los diferentes estados de la máquina de café
 */
sealed class CoffeeMachineState {
    object Idle : CoffeeMachineState() {
        fun onEnter(monedero: Int) {
            println("Entrando al estado Idle")
            Thread.sleep(2000)
            if (CoffeeMachine.monedero >0) {
                println("¡Monedero es mayor que cero! Me pongo a preparar cafe. Estado: $currentState")
                // Simula un proceso de preparación
                currentState = CoffeeMachineState.MakingCoffee(type = CoffeeMachine.seleccion)
            }
        }
        override fun toString(): String {
            return "Idle(monedero=${CoffeeMachine.monedero})"
        }
    }
    data class MakingCoffee(var type: Bebidas) : CoffeeMachineState(){
        fun onEnter() {
            println("Entrando al estado MakingCoffee")
            type = CoffeeMachine.seleccion
            println("Preparando café de tipo: $type")
            Thread.sleep(5000) // termino de preparar el café
        }

        override fun toString(): String {
            return "MakingCoffee(type=$type)"
        }
    }
    data class ServingCoffee(var type: Bebidas) : CoffeeMachineState() {
        fun onEnter() {
            type = CoffeeMachine.seleccion
            println("Entrando al estado ServingCoffee, sirviendo $type")
            Thread.sleep(5000) // termino de preparar el café
            println("Ya hay café servido. Por favor, toma tu café.")
        }

        override fun toString(): String {
            return "ServingCoffee(type=$type)"
        }
    }
    data class Error(val message: String) : CoffeeMachineState(){
        fun onEnter() {
            println("Entrando al estado Error: $message")
        }
    }
}

