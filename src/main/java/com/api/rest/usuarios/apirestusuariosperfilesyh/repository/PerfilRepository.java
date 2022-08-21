package com.api.rest.usuarios.apirestusuariosperfilesyh.repository;

import com.api.rest.usuarios.apirestusuariosperfilesyh.entity.Perfil;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PerfilRepository extends CrudRepository<Perfil, Long> {
    Collection<Perfil> findAll();
}
