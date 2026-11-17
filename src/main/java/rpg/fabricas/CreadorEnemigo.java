package rpg.fabricas;

import rpg.personajes.Personaje;

/**
 * PATRÓN FACTORY METHOD -> "Creador" abstracto para los ENEMIGOS.
 * crearEnemigo() es el método fábrica; cada subclase arma un enemigo distinto.
 */
public abstract class CreadorEnemigo {
    public abstract Personaje crearEnemigo();
}
