/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Estudiante;

/**
 *
 * @author tomichveronica
 */
public interface EstudianteDao {
    
    Estudiante buscarEstudiante(String Email);
    void guardarEstudiante(Estudiante estudiante);
}
