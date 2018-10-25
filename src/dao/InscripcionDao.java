/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Curso;
import model.Estudiante;
import model.Inscripcion;

/**
 *
 * @author tomichveronica
 */
public interface InscripcionDao {
    void guardarInscripcion(Inscripcion inscripcion);
    Long getCantidadPorEstudiante(Estudiante estudiante);
    Long getCantidadPorCurso(Curso curso);
    Boolean estaInscripto(Estudiante estudiante, Curso curso);
}


