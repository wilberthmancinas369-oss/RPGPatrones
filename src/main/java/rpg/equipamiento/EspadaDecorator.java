package rpg.equipamiento;

import rpg.personajes.Personaje;

/**
 * PATRÓN DECORATOR -> "Decorador concreto" que modifica ATRIBUTOS.
 * Espada: +10 de ataque.
 */
public class EspadaDecorator extends PersonajeDecorator {

    public EspadaDecorator(Personaje personaje) { super(personaje); }

    @Override public int getAtaque() { return personaje.getAtaque() + 10; }

    @Override public String getDescripcion() { return personaje.getDescripcion() + " + Espada"; }
}
