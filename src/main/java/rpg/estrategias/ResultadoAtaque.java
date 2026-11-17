package rpg.estrategias;

/** Datos que regresa un ataque: cuánto daño hizo, si fue crítico y qué efecto tuvo. */
public class ResultadoAtaque {
    private final int dano;
    private final boolean critico;
    private final String efecto;

    public ResultadoAtaque(int dano, boolean critico, String efecto) {
        this.dano = dano;
        this.critico = critico;
        this.efecto = efecto;
    }

    public int getDano() { return dano; }
    public boolean isCritico() { return critico; }
    public String getEfecto() { return efecto; }
}
