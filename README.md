# Máquina de Estados... de Café

## Funciones en los estados

En esta rama vamos añadir una funcionalidad a los estados.+

### Función `onEnter()`

Cuando la máquina llega a un estado ejecuta esta función, todos los estados tienen esta función
## Diagrama Máquina

```mermaid
stateDiagram-v2
    [*] --> Idle
    Idle --> MakingCoffee : gestorEstados(monedero > 0)
    Idle --> Idle : gestorEstados(monedero <= 0)
    MakingCoffee --> ServingCoffee : gestorEstados()
    ServingCoffee --> Idle : gestorEstados()
    Error --> Error : gestorEstados()
    Idle --> Idle : clean()
    MakingCoffee --> Idle : clean()
    ServingCoffee --> Idle : clean()
    Error --> Idle : clean()
```