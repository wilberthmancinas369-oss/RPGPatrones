package rpg.estrategias;

import rpg.personajes.Personaje;

/**
 * PATRÓN STRATEGY -> "Estrategia concreta".
 * Golpe físico: daño = ataque - defensa del objetivo (mínimo 1).
 */
public class AtaqueEspada implements EstrategiaAtaque {
    @Override
    public ResultadoAtaque atacar(Personaje atacante, Personaje objetivo) {
        int dano = Math.max(1, atacante.getAtaque() - objetivo.getDefensa());
        return new ResultadoAtaque(dano, false, "espadazo");
    }
}
