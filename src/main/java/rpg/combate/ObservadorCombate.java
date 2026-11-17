package rpg.combate;

import rpg.estrategias.ResultadoAtaque;
import rpg.personajes.Personaje;

/**
 * PATRÓN OBSERVER (opcional) -> "Observador".
 * El MotorCombate avisa a todos sus observadores cada vez que pasa algo,
 * sin saber quiénes son (aquí: la bitácora; podría ser también un HUD).
 */
public interface ObservadorCombate {
    void alAtacar(int turno, Personaje atacante, Personaje defensor, ResultadoAtaque resultado);
    void alTerminar(Personaje ganador, Personaje perdedor, int turnos);
}
