package org.example

/**
 * Singleton que maneja lo que ocurre en cada estado
 */
object CoffeeMachine {
    public var currentState: CoffeeMachineState = CoffeeMachineState.Idle()

    fun gestorEstados() {
        println("Estado actual: $currentState")

        when (currentState) {
            is CoffeeMachineState.Idle -> {
                println("Máquina en estado IDlE")
                Thread.sleep(2000)
                // Simula un proceso de preparación
                currentState = CoffeeMachineState.MakingCoffee
                println("¡Me pongo a preparar tu café! Estado: $currentState")
            }
            is CoffeeMachineState.MakingCoffee -> {
                println("¡Estoy Haciendo cafe! Por favor, espera...")
                Thread.sleep(2000) // termino de preparar el café
                currentState = CoffeeMachineState.ServingCoffee("Nescafé")
            }
            is CoffeeMachineState.ServingCoffee -> {
                println("Ya hay café servido. Por favor, toma tu café.")
                currentState = CoffeeMachineState.Idle()
            }
            is CoffeeMachineState.Error -> {
                println("La máquina tiene un error: ${(currentState as CoffeeMachineState.Error).message}")
            }
        }
    }

    fun clean() {
        println("Limpiando la máquina...")
        currentState = CoffeeMachineState.Idle()
        println("Máquina limpia. Estado: $currentState")
    }
}
