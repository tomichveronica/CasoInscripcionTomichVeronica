/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Curso;
import model.Estudiante;
import model.Inscripcion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author tomichveronica
 */
public class InscripcionDaoImpl implements InscripcionDao {

    private final SessionFactory sessionFactory;

    public InscripcionDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardarInscripcion(Inscripcion inscripcion) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(inscripcion);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Boolean estaInscripto(Estudiante estudiante, Curso curso) {
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);
        Root<Inscripcion> root = query.from(Inscripcion.class);
        query.select(builder.count(root));
        query.where(
                builder.and(
                        builder.equal(root.get("estudiante"), estudiante),
                        builder.equal(root.get("curso"), curso)
                )
        );

        Long cantidadInscripciones = session.createQuery(query).uniqueResult();

        return cantidadInscripciones > 0;
    }

    @Override
    public Long getCantidadPorEstudiante(Estudiante estudiante) {
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);
        Root<Inscripcion> root = query.from(Inscripcion.class);
        query.select(builder.count(root));
        query.where(builder.equal(root.get("estudiante"), estudiante));

        Long cantidadInscripciones = session.createQuery(query).uniqueResult();

        return cantidadInscripciones;
    }

    @Override
    public Long getCantidadPorCurso(Curso curso) {
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);
        Root<Inscripcion> root = query.from(Inscripcion.class);
        query.select(builder.count(root));
        query.where(builder.equal(root.get("curso"), curso));

        Long cantidadInscripciones = session.createQuery(query).uniqueResult();

        return cantidadInscripciones;
    }

}
