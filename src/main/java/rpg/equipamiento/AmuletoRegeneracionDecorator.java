package rpg.equipamiento;

import rpg.estrategias.ResultadoAtaque;
import rpg.personajes.Personaje;

/**
 * PATRÓN DECORATOR -> "Decorador concreto".
 * Amuleto de regeneración: +3 de defensa y recupera 2 HP en cada turno
 * (cada vez que su portador ataca).
 */
public class AmuletoRegeneracionDecorator extends PersonajeDecorator {

    public AmuletoRegeneracionDecorator(Personaje personaje) { super(personaje); }

    @Override public int getDefensa() { return personaje.getDefensa() + 3; }

    @Override
    protected ResultadoAtaque aplicarEfectos(ResultadoAtaque r, Personaje objetivo) {
        r = super.aplicarEfectos(r, objetivo);
        setHp(getHp() + 2); // regeneración
        return new ResultadoAtaque(r.getDano(), r.isCritico(), r.getEfecto() + " + regenera 2 HP");
    }

    @Override public String getDescripcion() { return personaje.getDescripcion() + " + Amuleto"; }
}
