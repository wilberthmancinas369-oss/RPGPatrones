package rpg.equipamiento;

import rpg.estrategias.ResultadoAtaque;
import rpg.personajes.Personaje;

/**
 * PATRÓN DECORATOR -> "Decorador concreto" que modifica ATRIBUTOS y el ATAQUE.
 * Veneno: +5 de ataque y agrega el efecto "veneno" a cada golpe.
 */
public class VenenoDecorator extends PersonajeDecorator {

    public VenenoDecorator(Personaje personaje) { super(personaje); }

    @Override public int getAtaque() { return personaje.getAtaque() + 5; }

    @Override
    protected ResultadoAtaque aplicarEfectos(ResultadoAtaque r, Personaje objetivo) {
        r = super.aplicarEfectos(r, objetivo); // primero los efectos de adentro
        return new ResultadoAtaque(r.getDano(), r.isCritico(), r.getEfecto() + " + veneno");
    }

    @Override public String getDescripcion() { return personaje.getDescripcion() + " + Veneno"; }
}
