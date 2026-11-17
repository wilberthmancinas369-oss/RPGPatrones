package rpg.fabricas;

import rpg.personajes.Personaje;

/**
 * PATRÓN FACTORY METHOD -> "Creador" abstracto para los HÉROES.
 *
 * crearPersonaje() es el "método fábrica": cada subclase decide qué
 * clase concreta construir, con qué atributos y con qué estrategia.
 * El cliente (ConsolaJuego) solo conoce esta clase y la interfaz Personaje.
 */
public abstract class CreadorPersonaje {

    public abstract Personaje crearPersonaje(String nombre);

    // Hook opcional: validación común para todos los creadores
    protected void validarNombre(String nombre) {
        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("El nombre no puede estar vacío");
    }
}
