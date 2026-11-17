package rpg.bitacora;

/** PATRÓN DECORATOR -> "Decorador" abstracto de la bitácora. */
public abstract class BitacoraDecorator implements Bitacora {

    protected final Bitacora bitacora;
    protected final RegistroCombate registro;

    public BitacoraDecorator(Bitacora bitacora, RegistroCombate registro) {
        this.bitacora = bitacora;
        this.registro = registro;
    }

    @Override
    public String generar() {
        return bitacora.generar();
    }
}
