package rpg.personajes;

/**
 * Un enemigo es un PersonajeBase normal; lo único que cambia es que su
 * descripción no lleva la marca "(base)", porque los enemigos no se equipan.
 */
public class Enemigo extends PersonajeBase {

    public Enemigo(String nombre, int hp, int ataque, int defensa, int velocidad) {
        super(nombre, hp, ataque, defensa, velocidad);
    }

    @Override
    public String getDescripcion() { return getNombre(); }
}
