package rpg.fabricas;

import rpg.estrategias.AtaqueHechizo;
import rpg.personajes.Enemigo;
import rpg.personajes.Personaje;

/**
 * PATRÓN FACTORY METHOD -> "Creador concreto" de enemigos.
 * Dragón: mucha vida, su aliento de fuego funciona como hechizo.
 */
public class CreadorDragon extends CreadorEnemigo {
    @Override
    public Personaje crearEnemigo() {
        //                         nombre, HP, ATK, DEF, VEL
        Personaje e = new Enemigo("Dragón rojo", 150, 22, 14, 9);
        e.setEstrategia(new AtaqueHechizo());   // STRATEGY: forma de atacar del enemigo
        return e;
    }
}
