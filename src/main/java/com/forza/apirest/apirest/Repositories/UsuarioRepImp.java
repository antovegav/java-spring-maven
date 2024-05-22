package com.forza.apirest.apirest.Repositories;

import com.forza.apirest.apirest.models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;

// repositorio de la db
@Repository
// forma en la que trata las consultas de SQL
@Transactional
public class UsuarioRepImp implements UsuarioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();
    }


}
