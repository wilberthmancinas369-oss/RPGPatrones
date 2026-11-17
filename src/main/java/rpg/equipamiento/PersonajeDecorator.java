package rpg.equipamiento;

import rpg.estrategias.EstrategiaAtaque;
import rpg.estrategias.ResultadoAtaque;
import rpg.personajes.Personaje;

/**
 * PATRÓN DECORATOR -> "Decorador" abstracto.
 *
 * Implementa Personaje y a la vez GUARDA un Personaje adentro (el que envuelve).
 * Por defecto todo se reenvía al personaje envuelto; cada decorador concreto
 * solo sobrescribe lo que cambia (ataque, defensa, descripción, etc.).
 *
 * Así se puede combinar: new Bendicion(new Veneno(new Espada(mago)))
 * sin crear una subclase por cada combinación.
 */
public abstract class PersonajeDecorator implements Personaje {

    protected final Personaje personaje;

    public PersonajeDecorator(Personaje personaje) {
        this.personaje = personaje;
    }

    @Override public String getNombre() { return personaje.getNombre(); }
    @Override public int getAtaque() { return personaje.getAtaque(); }
    @Override public int getDefensa() { return personaje.getDefensa(); }
    @Override public int getVelocidad() { return personaje.getVelocidad(); }
    @Override public int getHp() { return personaje.getHp(); }
    @Override public void setHp(int hp) { personaje.setHp(hp); }
    @Override public EstrategiaAtaque getEstrategia() { return personaje.getEstrategia(); }
    @Override public void setEstrategia(EstrategiaAtaque e) { personaje.setEstrategia(e); }
    @Override public String getDescripcion() { return personaje.getDescripcion(); }

    /**
     * IMPORTANTE: le pasamos "this" (el personaje YA decorado) a la estrategia,
     * para que el daño se calcule con los atributos modificados por TODO el
     * equipamiento. Si solo hiciéramos personaje.atacar(objetivo), el
     * PersonajeBase atacaría con sus stats originales y la espada no serviría.
     *
     * Después se aplican los efectos extra de cada decorador (veneno, fuego...).
     */
    @Override
    public ResultadoAtaque atacar(Personaje objetivo) {
        ResultadoAtaque resultado = getEstrategia().atacar(this, objetivo);
        return aplicarEfectos(resultado, objetivo);
    }

    /**
     * Cada decorador puede modificar el resultado del ataque.
     * Por defecto solo pasa el resultado al decorador de adentro (si hay).
     */
    protected ResultadoAtaque aplicarEfectos(ResultadoAtaque resultado, Personaje objetivo) {
        if (personaje instanceof PersonajeDecorator interno) {
            return interno.aplicarEfectos(resultado, objetivo);
        }
        return resultado;
    }
}
