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
import model.Tematica;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author tomichveronica
 */
public class CursoDaoImpl implements CursoDao {

    private final SessionFactory sessionFactory;

    public CursoDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Curso> buscarCursos(Tematica tematica) {
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Curso> query = builder.createQuery(Curso.class);
        Root<Curso> root = query.from(Curso.class);
        query.select(root);
        query.where(builder.equal(root.get("tematica"), tematica));

        List<Curso> cursos = session.createQuery(query).list();

        return cursos;
    }
}
