/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author tomichveronica
 */
public class Curso {
    
    private int id;
    private Tematica tematica;
    private Profesor profesor;
    private String nombre;
    private String aula;
    private String duracion;
    private String cargaHoraria;
    private int cupo;
    
    
    public Curso() {
    }

    public Curso(Tematica tematica, Profesor profesor, String nombre, String aula, String duracion, String cargaHoraria, int cupo) {
        this.tematica = tematica;
        this.profesor = profesor;
        this.nombre = nombre;
        this.aula = aula;
        this.duracion = duracion;
        this.cargaHoraria = cargaHoraria;
        this.cupo = cupo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tematica getTematica() {
        return tematica;
    }

    public void setTematica(Tematica tematica) {
        this.tematica = tematica;
    } 
    
    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }
    
    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }    

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }
    
}
