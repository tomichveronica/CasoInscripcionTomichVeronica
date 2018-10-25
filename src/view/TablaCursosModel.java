/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Curso;

/**
 *
 * @author tomichveronica
 */
public final class TablaCursosModel extends AbstractTableModel {

    private static final String[] COLUMNAS = { "Nombre", "Profesor", "Aula", "Duración", "Carga Horaria", "Cupo" };
    
    private List<Curso> cursos;

    public TablaCursosModel (List<Curso> cursos) {
        super();
        this.cursos = cursos;
    }

    @Override
    public int getRowCount() {
        return cursos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNAS.length;
    }

    @Override
    public String getColumnName(int i) {
        return COLUMNAS[i];
    }

    
    @Override
    public Object getValueAt(int fila, int columna) {
        Object retorno = null;
        Curso curso = cursos.get(fila);
        
        // según la columna deseada obtenemos el valor a mostrar
        switch (columna) {
            case 0:
                retorno = curso.getNombre();
                break;
            case 1:
                retorno = curso.getProfesor();
                break;
            case 2:
                retorno = curso.getAula();
                break;
            case 3:
                retorno = curso.getDuracion();
                break;
            case 4:
                retorno = curso.getCargaHoraria();
                break;
            case 5:
                retorno = curso.getCupo();
                break;                
        }
        
        return retorno;
    }
    
    public Curso obtenerCursoEn (int fila) {
        return cursos.get(fila);
    }    

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
    
}
