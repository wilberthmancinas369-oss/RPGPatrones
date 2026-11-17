package rpg.bitacora;

/** PATRÓN DECORATOR -> "Componente concreto": solo lista los ataques. */
public class BitacoraBasica implements Bitacora {

    protected final RegistroCombate registro;

    public BitacoraBasica(RegistroCombate registro) {
        this.registro = registro;
    }

    @Override
    public String generar() {
        StringBuilder sb = new StringBuilder("=== BITÁCORA DE COMBATE ===\n");
        for (String linea : registro.getLineas()) {
            sb.append(linea).append("\n");
        }
        return sb.toString();
    }
}
