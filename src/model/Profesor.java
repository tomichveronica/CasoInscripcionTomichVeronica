/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author tomichveronica
 */
public class Profesor extends Persona {
    
    private String descripcion;

    public Profesor() {
    }
    
    public Profesor(String nombre, String apellido, String direccion, long telefono, Date fechaNac, String descripcion) {
        super(nombre, apellido, direccion, telefono, fechaNac);
        this.descripcion = descripcion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String email) {
        this.descripcion = email;
    }    

    @Override
    public String toString() {
        return this.getNombre() + " " + this.getApellido();
    }
    
    
}
