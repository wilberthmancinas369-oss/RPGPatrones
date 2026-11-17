package rpg.equipamiento;

import rpg.personajes.Personaje;

/**
 * PATRÓN DECORATOR -> "Decorador concreto" que modifica ATRIBUTOS.
 * Armadura: +8 de defensa.
 */
public class ArmaduraDecorator extends PersonajeDecorator {

    public ArmaduraDecorator(Personaje personaje) { super(personaje); }

    @Override public int getDefensa() { return personaje.getDefensa() + 8; }

    @Override public String getDescripcion() { return personaje.getDescripcion() + " + Armadura"; }
}
