/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CursoDao;
import dao.CursoDaoImpl;
import dao.EstudianteDao;
import dao.EstudianteDaoImpl;
import dao.InscripcionDaoImpl;
import dao.TematicaDao;
import dao.TematicaDaoImpl;
import java.util.List;
import model.Curso;
import model.Estudiante;
import model.Inscripcion;
import model.Tematica;
import org.hibernate.SessionFactory;
import view.PantallaInscripcion;

/**
 *
 * @author tomichveronica
 */
public class InscripcionController {

    private final SessionFactory sessionFactory;
    private final EstudianteDao estudianteDao;
    private final TematicaDao tematicaDao;
    private final CursoDao cursoDao;
    private final InscripcionDaoImpl inscripcionDao;
    private PantallaInscripcion pantallaInscripcion;
    private RegistracionController registracionController;

    InscripcionController(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

        this.estudianteDao = new EstudianteDaoImpl(sessionFactory);
        this.tematicaDao = new TematicaDaoImpl(sessionFactory);
        this.cursoDao = new CursoDaoImpl(sessionFactory);
        this.inscripcionDao = new InscripcionDaoImpl(sessionFactory);
        
        this.registracionController = new RegistracionController(sessionFactory, this);
    }

    public void run() {
        this.pantallaInscripcion = new PantallaInscripcion(this);
        this.pantallaInscripcion.setVisible(true);
    }

    public Estudiante buscarEstudiante(String email) {
        Estudiante estudiante = this.estudianteDao.buscarEstudiante(email);

        return estudiante;
    }

    public List<Tematica> buscarTematicas() {
        List<Tematica> tematicas = this.tematicaDao.buscarTematicas();

        return tematicas;
    }

    public List<Curso> buscarCursos(Tematica tematica) {
        List<Curso> cursos = this.cursoDao.buscarCursos(tematica);

        return cursos;
    }

    public void guardarInscripcion(Estudiante estudiante, Curso curso) {
        if (estudiante == null) {
            this.pantallaInscripcion.mostrarMensaje("Debe seleccionar un estudiante");
        } else if (curso == null) {
            this.pantallaInscripcion.mostrarMensaje("Debe seleccionar un curso");
        } else if (inscripcionDao.estaInscripto(estudiante, curso)) {
            this.pantallaInscripcion.mostrarMensaje("El estudiante ya se encuentra inscripto al curso");
        } else if (inscripcionDao.getCantidadPorEstudiante(estudiante) >= 3) {
            this.pantallaInscripcion.mostrarMensaje("El ya se encuentra inscripto a 3 cursos");
        } else if (inscripcionDao.getCantidadPorCurso(curso) >= curso.getCupo()) {
            if (this.pantallaInscripcion.mostrarMensajeConfirmacionGuardadoCondicional()) {
                Inscripcion inscripcion = new Inscripcion(curso, estudiante, true);
                this.inscripcionDao.guardarInscripcion(inscripcion);
            }
            
            this.pantallaInscripcion.mostrarMensaje("El alumnos ha sido inscripto en forma condicional al curso" + curso.getNombre());
        } else {

            if (this.pantallaInscripcion.mostrarMensajeConfirmacionGuardado()) {
                Inscripcion inscripcion = new Inscripcion(curso, estudiante, false);

                this.inscripcionDao.guardarInscripcion(inscripcion);
            }
            
            this.pantallaInscripcion.mostrarMensaje("El alumnos ha sido inscripto al curso" + curso.getNombre());
        }

    }

    public void mostrarRegistracion() {
        this.registracionController.mostrarRegistracion();
    }

    void actualizarEstudianteInscripcion(String email) {
        this.pantallaInscripcion.actualizarEstudianteInscripcion(email);
    }
}
