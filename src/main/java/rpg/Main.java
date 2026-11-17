package rpg;

import rpg.consola.ConsolaJuego;

/**
 * Punto de entrada. Ejecutar desde IntelliJ (botón Run) y contestar en consola.
 *
 * Patrones aplicados (ver comentarios "PATRÓN ..." en cada clase):
 *   - STRATEGY        -> paquete rpg.estrategias   (formas de atacar)
 *   - FACTORY METHOD  -> paquete rpg.fabricas      (crear héroes y enemigos)
 *   - DECORATOR       -> paquete rpg.equipamiento  (equipo combinable)
 *                        paquete rpg.bitacora      (bitácora enriquecible)
 *   - OBSERVER (opc.) -> rpg.combate.ObservadorCombate + rpg.bitacora.RegistroCombate
 */
public class Main {
    public static void main(String[] args) {
        new ConsolaJuego().iniciar();
    }
}
