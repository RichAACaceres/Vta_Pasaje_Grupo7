
package vta_pasaje_grupo7;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

import vta_pasaje_grupo7.AccesoDato.*;
import vta_pasaje_grupo7.Entidades.*;

public class Principal {
 
    public static void main(String[] args) {
       Ruta ruta=new Ruta(1,"San Luis","Villa Mercedes", LocalTime.of(1, 30),true);
       Ruta ruta2=new Ruta(2,"San Luis","Buenos Aires", LocalTime.of(16, 30),true);
        Ruta ruta3=new Ruta("San Luis","Villa de la quebrada", LocalTime.of(0, 30),true);
       RutaData rd=new RutaData();
     
       //Guardar ruta
       //rd.guardarRuta(ruta3);
       
       //Listar rutas
    // for(Ruta r:rd.rutasDisponibles()){
      //    System.out.println("Origen: "+r.getOrigen());
//          System.out.println("Destino: "+r.getDestino());
//           
//    }


//Listar rutas por origen
String origen="San Luis";
String destino="buenos aires";
//for(Ruta r :rd.rutasPorOrigen(origen)){
//System.out.println("Origen: "+r.getOrigen());
//         System.out.println("Destino: "+r.getDestino());
//}

//Listar rutas por destino
//     for(Ruta r:rd.rutasPorDestino(destino)){
//System.out.println("Origen: "+r.getOrigen());
//         System.out.println("Destino: "+r.getDestino());
//}

//Cargar horario
Horario horario=new Horario(ruta3,LocalTime.of(10,30),LocalTime.of(11,30),true);
HorarioData hd=new HorarioData();
//hd.agregarHorario(horario);

//listar horarios por ruta
//for(Horario h:hd.horarioDisponiblesPorRuta(ruta)){
//    System.out.println("Origen: "+h.getRuta().getOrigen());
//    System.out.println("Destino: "+h.getRuta().getDestino());
//    System.out.println("Horario salida: "+h.getHoraSalida());
//    System.out.println("Horario llegada: "+h.getHoraLlegada());
//    System.out.println("----------------------------------------");
//    
//}

//Listar rutas por hora de salida
//for(Horario h:hd.horariosPorHoraDeSalida(horario,rd.rutasDisponibles())){
// System.out.println("Origen: "+h.getRuta().getOrigen());
//  System.out.println("Destino: "+h.getRuta().getDestino());
//  System.out.println("Horario salida: "+h.getHoraSalida());
// System.out.println("Horario llegada: "+h.getHoraLlegada());
//  System.out.println("----------------------------------------");
//}

//Guardar pasajero
Pasajero pasajero=new Pasajero(2,"Alfredo","Zapata",34535678,"m@gmail.com",43654677,true);
Pasajero pasajero2=new Pasajero(4,"Samuel","Correa",25454675,"m@gmail.com",346564,true);
PasajeroData pd=new PasajeroData();
//pd.agregarPasajeros(pasajero);

//Listar pasajeros disponibles
//for(Pasajero p:pd.listaDePasajeros()){
//    System.out.println("Nombre: "+p.getNombre());
//    System.out.println("--------------------");
//
//}

//Devolver pasajero por dni
//System.out.println(pd.PasajeroPorDni(34535678));

//Cargar colectivo
Colectivo colectivo=new Colectivo(1,"COLE1","Mercedes","1114",24,true);
Colectivo colectivo2=new Colectivo(2,"COLE2","Volvo","64",64,true);
ColectivoData cd=new ColectivoData();
//cd.cargarColectivo(colectivo);
//cd.cargarColectivo(colectivo2);

//Listar colectivos disponibles
//for(Colectivo c:cd.listarColectivos()){
//    System.out.println("idColectivo: "+c.getIdColectivo());
//    System.out.println("Matricula: "+c.getMatricula());
//    
//}


Pasaje pasaje=new Pasaje(pasajero,colectivo,ruta,LocalDate.of(2024,10,1),LocalTime.of(14,00),25,20.500);
Pasaje pasaje2=new Pasaje(pasajero2,colectivo2,ruta2,LocalDate.of(2024,7,12),LocalTime.of(8,00),12,11111);
PasajeData pasajeData=new PasajeData();
   //pasajeData.venderPasaje(pasaje2);
   
   //Historial pasajes vendidos
       //ArrayList<Pasaje> pasajes=new ArrayList();
       
       //pasajes=pasajeData.pasajesVendidos(rd.rutasDisponibles(),pd.listaDePasajeros(),cd.listarColectivos());
        
//       for(Pasaje p :pasajes){
//       System.out.println("Ruta: "+p.getRuta().getOrigen()+" a "+p.getRuta().getDestino());
//       System.out.println("Asiento: "+p.getAsiento());
//       System.out.println("Pasajero: "+p.getPasajero().getNombre()+" "+p.getPasajero().getApellido());
//       System.out.println("Fecha de viaje: "+p.getFechaViaje());
//       System.out.println("Hora de viaje: "+p.getHoraViaje());
//       System.out.println("Precio: "+p.getPrecio());
//       System.out.println("-------------------------------------------------------------");
//   }

//Listar pasajes por ruta
//System.out.println("Origen:");
//        Scanner leer=new Scanner(System.in);
//        String or=leer.nextLine();
//        
//        System.out.println("Destino:");
//        String de=leer.nextLine();
//        System.out.println("------------------------------------------------------");
//             for(Pasaje p :pasajeData.pasajesVendidosPorRuta(or, de,rd.rutasDisponibles(),pd.listaDePasajeros(), cd.listarColectivos())){
//       System.out.println("Ruta: "+p.getRuta().getOrigen()+" a "+p.getRuta().getDestino());
//      System.out.println("Asiento: "+p.getAsiento());
//       System.out.println("Pasajero: "+p.getPasajero().getNombre()+" "+p.getPasajero().getApellido());
//       System.out.println("Fecha de viaje: "+p.getFechaViaje());
//       System.out.println("Hora de viaje: "+p.getHoraViaje());
//     System.out.println("Precio: "+p.getPrecio());
//      System.out.println("-------------------------------------------------------------");
//  }
        
//Anular venta
//pasajeData.anularVenta(5);
        
    }
    
}
