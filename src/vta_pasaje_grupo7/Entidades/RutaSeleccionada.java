
package vta_pasaje_grupo7.Entidades;


public class RutaSeleccionada {
    private static Ruta rutaSeleccionada;

    public static void setRutaSeleccionada(Ruta ruta) {
        rutaSeleccionada = ruta;
    }

    public static Ruta getRutaSeleccionada() {
        return rutaSeleccionada;
    }
}
