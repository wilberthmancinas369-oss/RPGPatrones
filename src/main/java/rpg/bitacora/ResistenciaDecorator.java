package rpg.bitacora;

/** PATRÓN DECORATOR -> "Decorador concreto": agrega la defensa (resistencia) de cada combatiente. */
public class ResistenciaDecorator extends BitacoraDecorator {

    public ResistenciaDecorator(Bitacora bitacora, RegistroCombate registro) {
        super(bitacora, registro);
    }

    @Override
    public String generar() {
        return bitacora.generar()
                + "[Resistencia] Defensa de " + registro.getNombreHeroe() + ": " + registro.getDefensaHeroe()
                + " | Defensa de " + registro.getNombreEnemigo() + ": " + registro.getDefensaEnemigo() + "\n";
    }
}
