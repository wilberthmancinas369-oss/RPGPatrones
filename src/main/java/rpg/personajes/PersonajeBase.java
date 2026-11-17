package rpg.personajes;

import rpg.estrategias.EstrategiaAtaque;
import rpg.estrategias.ResultadoAtaque;

/**
 * Personaje "desnudo", sin equipamiento.
 *
 * PATRÓN DECORATOR -> "Componente concreto" (el objeto que se envuelve).
 * PATRÓN STRATEGY  -> "Contexto": guarda una EstrategiaAtaque y le DELEGA
 *                     el ataque, en lugar de usar if/else por tipo de clase.
 */
public class PersonajeBase implements Personaje {
    private final String nombre;
    private int hp;
    private final int ataque;
    private final int defensa;
    private final int velocidad;
    private EstrategiaAtaque estrategia;

    public PersonajeBase(String nombre, int hp, int ataque, int defensa, int velocidad) {
        this.nombre = nombre;
        this.hp = hp;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
    }

    @Override public String getNombre() { return nombre; }
    @Override public int getAtaque() { return ataque; }
    @Override public int getDefensa() { return defensa; }
    @Override public int getVelocidad() { return velocidad; }
    @Override public int getHp() { return hp; }
    @Override public void setHp(int hp) { this.hp = Math.max(0, hp); }
    @Override public EstrategiaAtaque getEstrategia() { return estrategia; }
    @Override public void setEstrategia(EstrategiaAtaque e) { this.estrategia = e; }

    // STRATEGY: el personaje no sabe CÓMO ataca, se lo pide a su estrategia.
    @Override
    public ResultadoAtaque atacar(Personaje objetivo) {
        return estrategia.atacar(this, objetivo);
    }

    @Override
    public String getDescripcion() { return nombre + " (base)"; }
}
