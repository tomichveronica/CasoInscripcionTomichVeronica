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
public class Estudiante extends Persona {
    private String email;
    private String tutor;

    public Estudiante() {
    }
    
    public Estudiante(String nombre, String apellido, String direccion, int telefono, Date fechaNac, String email, String tutor) {
        super(nombre, apellido, direccion, telefono, fechaNac);
        this.email = email;
        this.tutor = tutor;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }        
}
