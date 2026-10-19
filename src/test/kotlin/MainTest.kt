package org.example

import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class MainTest {

    @BeforeTest
    fun resetMachineBeforeTest() {
        resetMachine()
    }

    @AfterTest
    fun resetMachineAfterTest() {
        resetMachine()
    }

    @Test
    fun followsTheScenarioFromMain() {
        CoffeeMachine.monedero = 1

        assertEquals(
            CoffeeMachineState.MakingCoffee(Bebidas.NOBEBIDA),
            CoffeeMachine.gestorEstados()
        )

        CoffeeMachine.seleccion = Bebidas.AMERICANO

        assertEquals(
            CoffeeMachineState.ServingCoffee(Bebidas.AMERICANO),
            CoffeeMachine.gestorEstados()
        )
        assertEquals(CoffeeMachineState.Idle, CoffeeMachine.gestorEstados())
    }

    @Test
    fun staysIdleWhenWalletIsZero() {
        CoffeeMachine.monedero = 0

        assertEquals(CoffeeMachineState.Idle, CoffeeMachine.gestorEstados())
    }

    private fun resetMachine() {
        CoffeeMachine.monedero = 0
        CoffeeMachine.seleccion = Bebidas.NOBEBIDA
        CoffeeMachine.currentState = CoffeeMachineState.Idle
    }
}
