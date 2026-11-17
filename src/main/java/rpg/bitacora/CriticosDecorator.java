package rpg.bitacora;

/** PATRÓN DECORATOR -> "Decorador concreto": agrega el conteo de golpes críticos. */
public class CriticosDecorator extends BitacoraDecorator {

    public CriticosDecorator(Bitacora bitacora, RegistroCombate registro) {
        super(bitacora, registro);
    }

    @Override
    public String generar() {
        return bitacora.generar()
                + "[Críticos] Golpes críticos en el combate: " + registro.getCriticos() + "\n";
    }
}
