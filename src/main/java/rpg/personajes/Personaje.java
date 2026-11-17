package rpg.personajes;

import rpg.estrategias.EstrategiaAtaque;
import rpg.estrategias.ResultadoAtaque;

/**
 * Interfaz común de todos los personajes (héroes y enemigos).
 *
 * PATRÓN DECORATOR -> este es el "Componente".
 *   Tanto PersonajeBase (componente concreto) como los decoradores de
 *   equipamiento implementan esta misma interfaz, por eso se pueden
 *   envolver unos a otros.
 *
 * PATRÓN FACTORY METHOD -> este es el "Producto".
 *   Los creadores (CreadorMago, CreadorGoblin, ...) regresan un Personaje,
 *   así el cliente nunca conoce la clase concreta.
 */
public interface Personaje {
    String getNombre();
    int getAtaque();
    int getDefensa();
    int getVelocidad();
    int getHp();
    void setHp(int hp);
    EstrategiaAtaque getEstrategia();
    void setEstrategia(EstrategiaAtaque estrategia);
    ResultadoAtaque atacar(Personaje objetivo);
    String getDescripcion();
}
