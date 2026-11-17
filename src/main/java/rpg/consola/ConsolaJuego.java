package rpg.consola;

import java.util.Scanner;
import rpg.bitacora.*;
import rpg.combate.MotorCombate;
import rpg.equipamiento.*;
import rpg.fabricas.*;
import rpg.personajes.Personaje;

/**
 * Cliente del juego (interfaz de consola).
 * Pide los datos al jugador y usa los patrones:
 *   1) FACTORY METHOD para crear héroe y enemigo.
 *   2) DECORATOR para equipar al héroe.
 *   3) STRATEGY (dentro del MotorCombate) para los ataques.
 *   4) OBSERVER + DECORATOR para la bitácora.
 */
public class ConsolaJuego {

    private final Scanner sc = new Scanner(System.in);

    public void iniciar() {
        System.out.println("===== RPG POR TURNOS =====");

        // ---------- 1. FACTORY METHOD: crear héroe ----------
        System.out.print("Nombre: ");
        String nombre = sc.nextLine().trim();

        System.out.println("Clases: 1) Guerrero  2) Mago  3) Arquero  4) Pícaro");
        System.out.print("Clase: ");
        CreadorPersonaje creador = elegirCreadorPersonaje(sc.nextLine().trim());
        Personaje heroe = creador.crearPersonaje(nombre);  // no sabemos la clase concreta

        // ---------- 2. DECORATOR: equipar al héroe ----------
        System.out.println("Equipo: 1) Espada  2) Armadura  3) Veneno  4) Amuleto  5) Bendición  6) Runa de fuego");
        System.out.print("Equipamiento (separado por comas, Enter = ninguno): ");
        heroe = equipar(heroe, sc.nextLine());

        // ---------- 1. FACTORY METHOD: crear enemigo ----------
        System.out.println("Enemigos: 1) Goblin  2) Orco  3) Dragón");
        System.out.print("Enemigo: ");
        CreadorEnemigo creadorEnemigo = elegirCreadorEnemigo(sc.nextLine().trim());
        Personaje enemigo = creadorEnemigo.crearEnemigo();

        System.out.println("Detalles de bitácora: 1) Críticos  2) Resistencia  3) Estadísticas  4) Victoria");
        System.out.print("Detalles (separados por comas, Enter = ninguno): ");
        String detalles = sc.nextLine();

        // ---------- Mostrar estado inicial ----------
        System.out.println();
        System.out.println("Héroe: " + heroe.getDescripcion());
        System.out.println("ATK: " + heroe.getAtaque()
                + " | DEF: " + heroe.getDefensa()
                + " | VEL: " + heroe.getVelocidad()
                + " | HP: " + heroe.getHp());
        System.out.println("Enemigo: " + enemigo.getNombre() + " | HP: " + enemigo.getHp());
        System.out.println();

        // ---------- 3. STRATEGY + OBSERVER: combate ----------
        MotorCombate motor = new MotorCombate();
        RegistroCombate registro = new RegistroCombate(heroe);
        motor.agregarObservador(registro);           // OBSERVER
        motor.iniciarCombate(heroe, enemigo);

        // ---------- 4. DECORATOR: bitácora enriquecida ----------
        Bitacora bitacora = new BitacoraBasica(registro);
        for (String d : detalles.split(",")) {
            switch (d.trim()) {
                case "1" -> bitacora = new CriticosDecorator(bitacora, registro);
                case "2" -> bitacora = new ResistenciaDecorator(bitacora, registro);
                case "3" -> bitacora = new EstadisticasDecorator(bitacora, registro);
                case "4" -> bitacora = new VictoriaDecorator(bitacora, registro);
                default -> { } // vacío o inválido: se ignora
            }
        }
        System.out.println();
        System.out.print(bitacora.generar());
    }

    // FACTORY METHOD: aquí solo se elige QUÉ creador usar; la creación la hace él.
    private CreadorPersonaje elegirCreadorPersonaje(String opcion) {
        return switch (opcion) {
            case "1" -> new CreadorGuerrero();
            case "3" -> new CreadorArquero();
            case "4" -> new CreadorPicaro();
            default -> new CreadorMago();
        };
    }

    private CreadorEnemigo elegirCreadorEnemigo(String opcion) {
        return switch (opcion) {
            case "2" -> new CreadorOrco();
            case "3" -> new CreadorDragon();
            default -> new CreadorGoblin();
        };
    }

    // DECORATOR: cada objeto ENVUELVE al personaje anterior (se pueden combinar libremente).
    private Personaje equipar(Personaje p, String opciones) {
        for (String op : opciones.split(",")) {
            switch (op.trim()) {
                case "1" -> p = new EspadaDecorator(p);
                case "2" -> p = new ArmaduraDecorator(p);
                case "3" -> p = new VenenoDecorator(p);
                case "4" -> p = new AmuletoRegeneracionDecorator(p);
                case "5" -> p = new BendicionDecorator(p);
                case "6" -> p = new RunaFuegoDecorator(p);
                default -> { }
            }
        }
        return p;
    }
}
