package rpg.bitacora;

/** PATRÓN DECORATOR -> "Decorador concreto": agrega estadísticas finales del combate. */
public class EstadisticasDecorator extends BitacoraDecorator {

    public EstadisticasDecorator(Bitacora bitacora, RegistroCombate registro) {
        super(bitacora, registro);
    }

    @Override
    public String generar() {
        return bitacora.generar()
                + "[Estadísticas] Turnos: " + registro.getTurnos()
                + " | Daño hecho por " + registro.getNombreHeroe() + ": " + registro.getDanoHeroe()
                + " | Daño hecho por " + registro.getNombreEnemigo() + ": " + registro.getDanoEnemigo() + "\n";
    }
}
