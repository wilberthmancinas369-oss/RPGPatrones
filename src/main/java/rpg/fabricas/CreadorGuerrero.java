package rpg.fabricas;

import rpg.estrategias.AtaqueEspada;
import rpg.personajes.Personaje;
import rpg.personajes.PersonajeBase;

/**
 * PATRÓN FACTORY METHOD -> "Creador concreto".
 * Guerrero: mucha vida y defensa, ataca con espada.
 */
public class CreadorGuerrero extends CreadorPersonaje {
    @Override
    public Personaje crearPersonaje(String nombre) {
        validarNombre(nombre);
        //                        nombre, HP, ATK, DEF, VEL
        Personaje p = new PersonajeBase(nombre, 120, 18, 15, 10);
        p.setEstrategia(new AtaqueEspada());   // STRATEGY: se le asigna su forma de atacar
        return p;
    }
}
