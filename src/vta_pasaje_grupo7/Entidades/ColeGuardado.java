
package vta_pasaje_grupo7.Entidades;

public class ColeGuardado {
    private static Colectivo coleGuardado;
    public static void setCole(Colectivo colectivo){
    coleGuardado=colectivo;
    }
    public static Colectivo getCole(){
   return coleGuardado;
    }
}
