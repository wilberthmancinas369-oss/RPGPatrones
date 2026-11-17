package rpg.estrategias;

import rpg.personajes.Personaje;

/**
 * PATRÓN STRATEGY -> "Estrategia concreta".
 * La magia ignora la armadura: daño = ataque completo del atacante.
 */
public class AtaqueHechizo implements EstrategiaAtaque {
    @Override
    public ResultadoAtaque atacar(Personaje atacante, Personaje objetivo) {
        int dano = atacante.getAtaque();
        return new ResultadoAtaque(dano, false, "hechizo");
    }
}
