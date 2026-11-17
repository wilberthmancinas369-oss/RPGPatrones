package rpg.estrategias;

import rpg.personajes.Personaje;

/**
 * PATRÓN STRATEGY -> "Estrategia concreta".
 * La flecha atraviesa parte de la armadura: solo cuenta la mitad de la defensa.
 */
public class AtaqueFlecha implements EstrategiaAtaque {
    @Override
    public ResultadoAtaque atacar(Personaje atacante, Personaje objetivo) {
        int dano = Math.max(1, atacante.getAtaque() - objetivo.getDefensa() / 2);
        return new ResultadoAtaque(dano, false, "flecha");
    }
}
