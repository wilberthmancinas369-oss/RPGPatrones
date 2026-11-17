package rpg.combate;

import java.util.ArrayList;
import java.util.List;
import rpg.estrategias.ResultadoAtaque;
import rpg.personajes.Personaje;

/**
 * Controla el combate por turnos y muestra el estado turno a turno.
 *
 * - STRATEGY: solo llama a atacante.atacar(defensor); NO sabe si es espada,
 *   hechizo, etc. Por eso agregar ataques nuevos no lo modifica.
 * - DECORATOR: el daño ya viene calculado con los atributos del equipamiento.
 * - OBSERVER: es el "Sujeto"; notifica a los observadores (bitácora).
 */
public class MotorCombate {

    private final List<ObservadorCombate> observadores = new ArrayList<>();

    // OBSERVER: registrar observadores
    public void agregarObservador(ObservadorCombate o) {
        observadores.add(o);
    }

    public void iniciarCombate(Personaje heroe, Personaje enemigo) {
        System.out.println("=== COMBATE INICIADO ===");
        int turno = 1;
        while (heroe.getHp() > 0 && enemigo.getHp() > 0) {
            System.out.println("\n--- TURNO " + turno + " ---");
            ejecutarTurno(turno, heroe, enemigo);
            if (enemigo.getHp() <= 0) break;
            ejecutarTurno(turno, enemigo, heroe);
            if (heroe.getHp() <= 0) break;
            turno++;
        }

        System.out.println("\n=== COMBATE FINALIZADO ===");
        Personaje ganador = heroe.getHp() > 0 ? heroe : enemigo;
        Personaje perdedor = heroe.getHp() > 0 ? enemigo : heroe;
        System.out.println("Ganador: " + ganador.getDescripcion()
                + " (HP restante: " + ganador.getHp() + ")");

        // OBSERVER: avisar que terminó
        for (ObservadorCombate o : observadores) {
            o.alTerminar(ganador, perdedor, turno);
        }
    }

    private void ejecutarTurno(int turno, Personaje atacante, Personaje defensor) {
        // STRATEGY (+ efectos de DECORATOR): el personaje delega en su estrategia
        ResultadoAtaque r = atacante.atacar(defensor);

        System.out.println(atacante.getDescripcion() + " usa "
                + atacante.getEstrategia().getClass().getSimpleName()
                + " sobre " + defensor.getDescripcion());
        System.out.println("  Daño: " + r.getDano()
                + (r.isCritico() ? " (¡CRÍTICO!)" : "")
                + " | Efecto: " + r.getEfecto());

        int hpAntes = defensor.getHp();
        defensor.setHp(hpAntes - r.getDano());
        System.out.println("  " + defensor.getDescripcion() + " HP: "
                + hpAntes + " -> " + defensor.getHp());

        // OBSERVER: avisar del ataque
        for (ObservadorCombate o : observadores) {
            o.alAtacar(turno, atacante, defensor, r);
        }
    }
}
