package rpg.equipamiento;

import rpg.personajes.Personaje;

/**
 * PATRÓN DECORATOR -> "Decorador concreto" que modifica ATRIBUTOS.
 * Bendición: +15% a ataque, defensa y velocidad (sobre lo que ya traiga
 * el personaje, por eso conviene ponerla al final).
 */
public class BendicionDecorator extends PersonajeDecorator {

    public BendicionDecorator(Personaje personaje) { super(personaje); }

    private int masQuincePorciento(int valor) {
        return (int) Math.round(valor * 1.15);
    }

    @Override public int getAtaque() { return masQuincePorciento(personaje.getAtaque()); }
    @Override public int getDefensa() { return masQuincePorciento(personaje.getDefensa()); }
    @Override public int getVelocidad() { return masQuincePorciento(personaje.getVelocidad()); }

    @Override public String getDescripcion() { return personaje.getDescripcion() + " + Bendición"; }
}
