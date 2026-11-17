package rpg.fabricas;

import rpg.estrategias.AtaqueFlecha;
import rpg.personajes.Personaje;
import rpg.personajes.PersonajeBase;

/**
 * PATRÓN FACTORY METHOD -> "Creador concreto".
 * Arquero: rápido, sus flechas atraviesan media armadura.
 */
public class CreadorArquero extends CreadorPersonaje {
    @Override
    public Personaje crearPersonaje(String nombre) {
        validarNombre(nombre);
        //                        nombre, HP, ATK, DEF, VEL
        Personaje p = new PersonajeBase(nombre, 100, 17, 8, 20);
        p.setEstrategia(new AtaqueFlecha());   // STRATEGY: se le asigna su forma de atacar
        return p;
    }
}
