package rpg.bitacora;

/**
 * PATRÓN DECORATOR (segundo uso) -> "Componente" de la bitácora.
 * La bitácora básica se puede ENRIQUECER envolviéndola con detalles
 * opcionales (críticos, resistencia, estadísticas, victoria).
 */
public interface Bitacora {
    String generar();
}
