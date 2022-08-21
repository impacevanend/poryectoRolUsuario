package com.api.rest.usuarios.apirestusuariosperfilesyh.repository;

import com.api.rest.usuarios.apirestusuariosperfilesyh.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    Collection<Usuario> findAll();
}
