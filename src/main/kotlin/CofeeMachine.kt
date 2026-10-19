package org.example

import org.example.CoffeeMachineState.*

/**
 * Singleton que maneja lo que ocurre en cada estado
 */
object CoffeeMachine {
    public var currentState: CoffeeMachineState = CoffeeMachineState.Idle()
    public var monedero: Int = 0
    public var seleccion: Bebidas = Bebidas.CAPUCCINO

    fun gestorEstados(): CoffeeMachineState {
        println("Estado actual: $currentState")

        when (currentState) {
            is CoffeeMachineState.Idle -> {
                (currentState as Idle).onEnter()
                Thread.sleep(2000)
                if (monedero>0) {

                    println("¡Monedero es mayor que cero! Me pongo a preparar cafe. Estado: $currentState")
                    // Simula un proceso de preparación
                    currentState = CoffeeMachineState.MakingCoffee(type = Bebidas.CAPUCCINO)
                }
            }
            is CoffeeMachineState.MakingCoffee -> {
                (currentState as MakingCoffee).onEnter()

                currentState = ServingCoffee(type = seleccion)
            }
            is CoffeeMachineState.ServingCoffee -> {
                (currentState as ServingCoffee).onEnter()
                println("Ya hay café servido. Por favor, toma tu café.")
                currentState = Idle()
            }
            is CoffeeMachineState.Error -> {
                println("La máquina tiene un error: ${(currentState as CoffeeMachineState.Error).message}")
            }
        }
        return currentState
    }

    fun clean() {
        println("Limpiando la máquina...")
        currentState = CoffeeMachineState.Idle()
        println("Máquina limpia. Estado: $currentState")
    }
}
