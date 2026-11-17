package rpg.equipamiento;

import rpg.estrategias.ResultadoAtaque;
import rpg.personajes.Personaje;

/**
 * PATRÓN DECORATOR -> "Decorador concreto" que modifica el DAÑO (atacar).
 * Runa de fuego: no cambia los atributos, pero cada golpe quema
 * al objetivo con +8 de daño extra.
 */
public class RunaFuegoDecorator extends PersonajeDecorator {

    public RunaFuegoDecorator(Personaje personaje) { super(personaje); }

    @Override
    protected ResultadoAtaque aplicarEfectos(ResultadoAtaque r, Personaje objetivo) {
        r = super.aplicarEfectos(r, objetivo);
        return new ResultadoAtaque(r.getDano() + 8, r.isCritico(), r.getEfecto() + " + fuego(+8)");
    }

    @Override public String getDescripcion() { return personaje.getDescripcion() + " + Runa de fuego"; }
}
