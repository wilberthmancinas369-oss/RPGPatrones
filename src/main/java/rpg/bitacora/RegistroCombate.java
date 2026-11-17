package rpg.bitacora;

import java.util.ArrayList;
import java.util.List;
import rpg.combate.ObservadorCombate;
import rpg.estrategias.ResultadoAtaque;
import rpg.personajes.Personaje;

/**
 * PATRÓN OBSERVER -> "Observador concreto".
 * Escucha al MotorCombate y va guardando los datos del combate
 * para que después la Bitácora los pueda imprimir.
 */
public class RegistroCombate implements ObservadorCombate {

    private final List<String> lineas = new ArrayList<>();
    private int criticos = 0;
    private int danoHeroe = 0;     // daño total que hizo el héroe
    private int danoEnemigo = 0;   // daño total que hizo el enemigo
    private String nombreHeroe = "";
    private String nombreEnemigo = "";
    private int defensaHeroe = 0;
    private int defensaEnemigo = 0;
    private String ganador = "";
    private int hpGanador = 0;
    private int turnos = 0;
    private boolean ganoHeroe = false;

    private final Personaje heroe;

    public RegistroCombate(Personaje heroe) {
        this.heroe = heroe;
    }

    @Override
    public void alAtacar(int turno, Personaje atacante, Personaje defensor, ResultadoAtaque r) {
        lineas.add("T" + turno + ": " + atacante.getNombre() + " -> " + defensor.getNombre()
                + " | " + r.getDano() + " de daño (" + r.getEfecto() + ")");
        if (r.isCritico()) criticos++;

        if (atacante == heroe) {
            danoHeroe += r.getDano();
            nombreHeroe = atacante.getNombre();
            nombreEnemigo = defensor.getNombre();
            defensaHeroe = atacante.getDefensa();
            defensaEnemigo = defensor.getDefensa();
        } else {
            danoEnemigo += r.getDano();
        }
    }

    @Override
    public void alTerminar(Personaje ganador, Personaje perdedor, int turnos) {
        this.ganador = ganador.getNombre();
        this.hpGanador = ganador.getHp();
        this.turnos = turnos;
        this.ganoHeroe = (ganador == heroe);
    }

    public List<String> getLineas() { return lineas; }
    public int getCriticos() { return criticos; }
    public int getDanoHeroe() { return danoHeroe; }
    public int getDanoEnemigo() { return danoEnemigo; }
    public String getNombreHeroe() { return nombreHeroe; }
    public String getNombreEnemigo() { return nombreEnemigo; }
    public int getDefensaHeroe() { return defensaHeroe; }
    public int getDefensaEnemigo() { return defensaEnemigo; }
    public String getGanador() { return ganador; }
    public int getHpGanador() { return hpGanador; }
    public int getTurnos() { return turnos; }
    public boolean isGanoHeroe() { return ganoHeroe; }
}
