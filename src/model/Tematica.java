/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tomichveronica
 */
public class Tematica {
    
    private int id;
    private String nombre;
    private List<Curso> cursos;    

    public Tematica() {
        this.cursos = new ArrayList();
    }
    
    public Tematica(String nombre) {
        this.nombre = nombre;
        this.cursos = new ArrayList();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    @Override
    public String toString() {
        return this.getNombre();
    }    
}
