
package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;


public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color, String observaciones, 
            String alergico, String atenEsp, String nombreDuenio, String celDuenio) {
            Duenio duenio = new Duenio();
            duenio.setNombre(nombreDuenio);
            duenio.setCelular(celDuenio);
            
            Mascota masco = new Mascota();
            masco.setNombre(nombreMasco);
            masco.setRaza(raza);
            masco.setColor(color);
            masco.setAlergico(alergico);
            masco.setAtencionEspecial(atenEsp);
            masco.setObservaciones(observaciones);
            masco.setUnDuenio(duenio);
            
            controlPersis.guardar(duenio,masco);
    }


    public void borrarMascota(int num_cliente) {
        controlPersis.borrarMascota(num_cliente);

    }

    public Mascota traerMascota(int num_cliente) {
        return controlPersis.traerMascota(num_cliente);

    }

    public List<Mascota> traerMascotas() {
        return controlPersis.traerMascotas();
    }

    public void modificarMascota(Mascota masco, String nombreMasco, String raza, String color, String observaciones, String alergico, String atenEsp, String nombreDuenio, String celDuenio) {
        masco.setNombre (nombreMasco); 
        masco.setRaza(raza); 
        masco.setColor(color); 
        masco.setObservaciones (observaciones); 
        masco.setAtencionEspecial(atenEsp); 
        masco.setAlergico(alergico); 
    //modifico mascota 
        controlPersis.modificarMascota (masco);
        
        //set los valores del dueño
        Duenio duenno = this.buscarDuenio(masco.getUnDuenio().getId_duenio());
        duenno.setCelular(celDuenio);
        duenno.setNombre(nombreDuenio);
        
        //llamar al modificador del dueño
        this.modificarDuenio(duenno);
    }

    private Duenio buscarDuenio(int id_duenio) {
        return controlPersis.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio duenno) {
        controlPersis.modificarDuenio(duenno);
    }


}
