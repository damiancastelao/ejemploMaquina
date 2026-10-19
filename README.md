# Máquina de Estados... de Café

## Tests

En esta rama vamos añadir los tests unitarios.

Tendremos que revisar el código para que las funciones tengan valores devueltos, y así poder testearlas.

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