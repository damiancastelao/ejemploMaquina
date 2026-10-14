package org.example

import org.example.CoffeeMachineState.*

/**
 * Singleton que maneja lo que ocurre en cada estado
 */
object CoffeeMachine {
    public var currentState: CoffeeMachineState = CoffeeMachineState.Idle()

    fun gestorEstados(monedero: Int) {
        println("Estado actual: $currentState")

        when (currentState) {
            is CoffeeMachineState.Idle if monedero>0 -> {
                println("Máquina en estado IDlE")
                Thread.sleep(2000)
                // Simula un proceso de preparación
                currentState = CoffeeMachineState.MakingCoffee
                println("¡Monedero es mayor que cero! Me pongo a preparar cafe. Estado: $currentState")
            }
            is CoffeeMachineState.MakingCoffee -> {
                println("¡Estoy Haciendo cafe! Por favor, espera...")
                Thread.sleep(2000) // termino de preparar el café
                currentState = ServingCoffee("Nescafé")
            }
            is CoffeeMachineState.ServingCoffee -> {
                println("Ya hay café servido. Por favor, toma tu café.")
                currentState = Idle()
            }
            is CoffeeMachineState.Error -> {
                println("La máquina tiene un error: ${(currentState as CoffeeMachineState.Error).message}")
            }

            is CoffeeMachineState.Idle -> {
                println("Sigo en el estado IDLE")
            }
        }
    }

    fun clean() {
        println("Limpiando la máquina...")
        currentState = CoffeeMachineState.Idle()
        println("Máquina limpia. Estado: $currentState")
    }
}
