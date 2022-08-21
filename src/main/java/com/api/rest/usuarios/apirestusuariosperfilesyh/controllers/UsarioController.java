package com.api.rest.usuarios.apirestusuariosperfilesyh.controllers;

import com.api.rest.usuarios.apirestusuariosperfilesyh.entity.Usuario;
import com.api.rest.usuarios.apirestusuariosperfilesyh.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsarioController {

    private UsuarioRepository usuarioRepository;

    public UsarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public ResponseEntity<Collection<Usuario>>listarUsuarios(){
        return new ResponseEntity<>(usuarioRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario>obtenerUsuairioPorId(@PathVariable Long id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        if(usuario != null){
            return new ResponseEntity<>(usuarioRepository.findById(id).orElseThrow(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Usuario>guardarUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity<>(usuarioRepository.save(usuario),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>eliminarUsuario(@PathVariable Long id){
        usuarioRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario>actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if(!usuarioOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }

        usuario.setId(usuarioOptional.get().getId());
        usuarioRepository.save(usuario);

        return ResponseEntity.noContent().build();
    }




}
