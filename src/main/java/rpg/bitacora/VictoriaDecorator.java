package rpg.bitacora;

/** PATRÓN DECORATOR -> "Decorador concreto": agrega la marca de victoria o derrota. */
public class VictoriaDecorator extends BitacoraDecorator {

    public VictoriaDecorator(Bitacora bitacora, RegistroCombate registro) {
        super(bitacora, registro);
    }

    @Override
    public String generar() {
        return bitacora.generar()
                + (registro.isGanoHeroe()
                    ? "*** ¡VICTORIA! " + registro.getGanador() + " gana con " + registro.getHpGanador() + " HP ***\n"
                    : "xxx DERROTA: " + registro.getGanador() + " ganó el combate xxx\n");
    }
}
