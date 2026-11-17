# RPG por turnos — Patrones de diseño (Strategy, Factory Method, Decorator)

Prototipo de videojuego RPG por turnos en Java (consola).
Abrir la carpeta en IntelliJ como proyecto Maven y ejecutar `rpg.Main`.

## ¿Dónde está cada patrón?

| Patrón | Paquete / clases | Para qué |
|---|---|---|
| **Strategy** | `rpg.estrategias`: `EstrategiaAtaque` (interfaz), `AtaqueEspada`, `AtaqueHechizo`, `AtaqueFlecha`, `AtaquePunalada` | Cada personaje ataca distinto. `PersonajeBase.atacar()` delega en su estrategia; `MotorCombate` no usa `if/else` por tipo. |
| **Factory Method** | `rpg.fabricas`: `CreadorPersonaje` → `CreadorGuerrero`, `CreadorMago`, `CreadorArquero`, `CreadorPicaro`; `CreadorEnemigo` → `CreadorGoblin`, `CreadorOrco`, `CreadorDragon` | Crear héroes y enemigos sin que el cliente (`ConsolaJuego`) conozca las clases concretas ni sus stats. |
| **Decorator** (equipo) | `rpg.equipamiento`: `PersonajeDecorator` → `EspadaDecorator`, `ArmaduraDecorator`, `VenenoDecorator`, `AmuletoRegeneracionDecorator`, `BendicionDecorator`, `RunaFuegoDecorator` | Equipo combinable en cualquier orden. Espada/Armadura/Bendición modifican **atributos**; Runa de fuego modifica el **daño** (`atacar`); Veneno y Amuleto hacen ambos. |
| **Decorator** (bitácora) | `rpg.bitacora`: `Bitacora`, `BitacoraBasica`, `BitacoraDecorator` → `CriticosDecorator`, `ResistenciaDecorator`, `EstadisticasDecorator`, `VictoriaDecorator` | Bitácora de combate enriquecible con detalles opcionales. |
| **Observer** (opcional) | `rpg.combate.ObservadorCombate`, `rpg.combate.MotorCombate` (sujeto), `rpg.bitacora.RegistroCombate` (observador) | El motor avisa cada ataque y el final del combate; la bitácora escucha. |

Cada clase tiene un comentario `PATRÓN ...` indicando su rol dentro del patrón.

## Equipamiento

| # | Objeto | Efecto |
|---|---|---|
| 1 | Espada | +10 ataque |
| 2 | Armadura | +8 defensa |
| 3 | Veneno | +5 ataque, agrega efecto "veneno" al golpe |
| 4 | Amuleto de regeneración | +3 defensa, +2 HP por turno |
| 5 | Bendición | +15 % a ataque, defensa y velocidad |
| 6 | Runa de fuego | +8 de daño en cada golpe |

## Ejecución

Las 4 corridas de prueba están en `EJECUCION.txt`.
