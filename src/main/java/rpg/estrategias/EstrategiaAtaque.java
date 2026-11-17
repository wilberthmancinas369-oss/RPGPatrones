package rpg.estrategias;

import rpg.personajes.Personaje;

/**
 * PATRÓN STRATEGY -> "Estrategia" (interfaz común de los algoritmos de ataque).
 *
 * Cada forma de atacar (espada, hechizo, flecha, puñalada) es una clase que
 * implementa esta interfaz. Para agregar una nueva (ej. AtaqueNigromancia)
 * solo se crea otra clase; el MotorCombate no se toca.
 */
public interface EstrategiaAtaque {
    ResultadoAtaque atacar(Personaje atacante, Personaje objetivo);
}
