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
public class Inscripcion {

    private int id;
    private Curso curso;
    private Estudiante estudiante;
    private Date fecha;
    private Boolean condicional;
    
    public Inscripcion() {
        this.fecha = new Date();
    }     
    
    public Inscripcion(Curso curso, Estudiante estudiante, Boolean condicional) {
        this.curso = curso;
        this.estudiante = estudiante;
        this.fecha = new Date();
        this.condicional = condicional;
    }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getCondicional() {
        return condicional;
    }

    public void setCondicional(Boolean condicional) {
        this.condicional = condicional;
    }
    
}
