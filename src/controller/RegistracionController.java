/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EstudianteDao;
import dao.EstudianteDaoImpl;
import java.util.Date;
import model.Estudiante;
import org.hibernate.SessionFactory;
import view.PantallaRegistracion;

/**
 *
 * @author tomichveronica
 */
public class RegistracionController {

    private final SessionFactory sessionFactory;
    private final PantallaRegistracion pantallaRegistracion;
    private final InscripcionController inscripcionController;
    private final EstudianteDao estudianteDao;
            


    RegistracionController(SessionFactory sessionFactory, InscripcionController inscripcionController) {
        this.sessionFactory = sessionFactory;
        this.inscripcionController = inscripcionController;
        this.pantallaRegistracion = new PantallaRegistracion(this);
        
        this.estudianteDao = new EstudianteDaoImpl(sessionFactory);
    }

    public void mostrarRegistracion() {
        this.pantallaRegistracion.borrarCampos();
        this.pantallaRegistracion.setVisible(true);
    }

    public void ocultarRegistracion() {
        this.pantallaRegistracion.setVisible(false);
    }

    public void guardarEstudiante(String nombre, String apellido, String direccion, long telefono, String email, Date fechaNac, String tutor) {
        Estudiante estudiante = new Estudiante(nombre, apellido, direccion, telefono, fechaNac, email, tutor);
        
        this.estudianteDao.guardarEstudiante(estudiante);
        
        this.inscripcionController.actualizarEstudianteInscripcion(estudiante.getEmail());
    }

    public boolean emailEnUso(String email) {
        Estudiante estudiante = this.inscripcionController.buscarEstudiante(email);
        return estudiante != null;
    }

}
