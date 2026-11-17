package rpg.fabricas;

import rpg.estrategias.AtaquePunalada;
import rpg.personajes.Enemigo;
import rpg.personajes.Personaje;

/**
 * PATRÓN FACTORY METHOD -> "Creador concreto" de enemigos.
 * Goblin: débil pero apuñala.
 */
public class CreadorGoblin extends CreadorEnemigo {
    @Override
    public Personaje crearEnemigo() {
        //                         nombre, HP, ATK, DEF, VEL
        Personaje e = new Enemigo("Goblin salvaje", 60, 13, 5, 12);
        e.setEstrategia(new AtaquePunalada());   // STRATEGY: forma de atacar del enemigo
        return e;
    }
}
