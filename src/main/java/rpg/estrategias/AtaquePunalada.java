package rpg.estrategias;

import rpg.personajes.Personaje;

/**
 * PATRÓN STRATEGY -> "Estrategia concreta".
 * Ataque sigiloso: si el atacante es MÁS RÁPIDO que el objetivo,
 * el golpe es CRÍTICO y hace el doble de daño.
 */
public class AtaquePunalada implements EstrategiaAtaque {
    @Override
    public ResultadoAtaque atacar(Personaje atacante, Personaje objetivo) {
        int dano = Math.max(1, atacante.getAtaque() - objetivo.getDefensa());
        boolean critico = atacante.getVelocidad() > objetivo.getVelocidad();
        if (critico) {
            dano = dano * 2;
        }
        return new ResultadoAtaque(dano, critico, "puñalada");
    }
}
