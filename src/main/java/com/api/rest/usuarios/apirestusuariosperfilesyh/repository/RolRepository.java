package com.api.rest.usuarios.apirestusuariosperfilesyh.repository;

import com.api.rest.usuarios.apirestusuariosperfilesyh.entity.Rol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface RolRepository extends CrudRepository<Rol, Long> {
    Collection<Rol> findAll();
}
