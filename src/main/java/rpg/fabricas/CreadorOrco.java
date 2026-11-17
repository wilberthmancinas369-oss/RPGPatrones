package rpg.fabricas;

import rpg.estrategias.AtaqueEspada;
import rpg.personajes.Enemigo;
import rpg.personajes.Personaje;

/**
 * PATRÓN FACTORY METHOD -> "Creador concreto" de enemigos.
 * Orco: fuerte y lento, pega con espada.
 */
public class CreadorOrco extends CreadorEnemigo {
    @Override
    public Personaje crearEnemigo() {
        //                         nombre, HP, ATK, DEF, VEL
        Personaje e = new Enemigo("Orco guerrero", 90, 24, 8, 8);
        e.setEstrategia(new AtaqueEspada());   // STRATEGY: forma de atacar del enemigo
        return e;
    }
}
