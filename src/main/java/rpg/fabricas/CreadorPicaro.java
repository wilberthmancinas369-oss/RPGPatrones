package rpg.fabricas;

import rpg.estrategias.AtaquePunalada;
import rpg.personajes.Personaje;
import rpg.personajes.PersonajeBase;

/**
 * PATRÓN FACTORY METHOD -> "Creador concreto".
 * Pícaro: el más veloz, hace críticos con puñaladas.
 */
public class CreadorPicaro extends CreadorPersonaje {
    @Override
    public Personaje crearPersonaje(String nombre) {
        validarNombre(nombre);
        //                        nombre, HP, ATK, DEF, VEL
        Personaje p = new PersonajeBase(nombre, 90, 16, 8, 22);
        p.setEstrategia(new AtaquePunalada());   // STRATEGY: se le asigna su forma de atacar
        return p;
    }
}
