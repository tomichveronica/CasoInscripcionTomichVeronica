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
import model.Estudiante;
import model.Tematica;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author tomichveronica
 */
public class TematicaDaoImpl implements TematicaDao{

    private final SessionFactory sessionFactory;
    
    public TematicaDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Tematica> buscarTematicas() {
        Session session = sessionFactory.openSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Tematica> query = builder.createQuery(Tematica.class);
        Root<Tematica> root = query.from(Tematica.class);
        query.select(root);
        
        List<Tematica> tematicas = session.createQuery(query).list();
        
        return tematicas;
    }    
}
