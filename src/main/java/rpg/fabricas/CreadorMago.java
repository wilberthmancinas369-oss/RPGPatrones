package rpg.fabricas;

import rpg.estrategias.AtaqueHechizo;
import rpg.personajes.Personaje;
import rpg.personajes.PersonajeBase;

/**
 * PATRÓN FACTORY METHOD -> "Creador concreto".
 * Mago: ataque mágico que ignora la defensa.
 */
public class CreadorMago extends CreadorPersonaje {
    @Override
    public Personaje crearPersonaje(String nombre) {
        validarNombre(nombre);
        //                        nombre, HP, ATK, DEF, VEL
        Personaje p = new PersonajeBase(nombre, 100, 20, 10, 15);
        p.setEstrategia(new AtaqueHechizo());   // STRATEGY: se le asigna su forma de atacar
        return p;
    }
}
