/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Estudiante;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author tomichveronica
 */
public class EstudianteDaoImpl implements EstudianteDao{

    private final SessionFactory sessionFactory;
    
    public EstudianteDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Estudiante buscarEstudiante(String email) {
        Session session = sessionFactory.openSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Estudiante> query = builder.createQuery(Estudiante.class);
        Root<Estudiante> root = query.from(Estudiante.class);
        query.select(root);
        query.where(builder.equal(root.get("email"), email));
        
        Estudiante estudiante = session.createQuery(query).uniqueResult();    
        
        return estudiante;
    }  
    
    @Override
    public void guardarEstudiante(Estudiante estudiante) {        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(estudiante);
        session.getTransaction().commit();
        session.close();     
    }    
}
