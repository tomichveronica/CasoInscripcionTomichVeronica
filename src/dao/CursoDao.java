/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Curso;
import model.Tematica;

/**
 *
 * @author tomichveronica
 */
public interface CursoDao {

    List<Curso> buscarCursos(Tematica tematica);

}
