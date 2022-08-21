package com.api.rest.usuarios.apirestusuariosperfilesyh.controllers;


import com.api.rest.usuarios.apirestusuariosperfilesyh.entity.Rol;
import com.api.rest.usuarios.apirestusuariosperfilesyh.repository.RolRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    private RolRepository rolRepository;

    public RolController(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @GetMapping
    public ResponseEntity<Collection<Rol>> listarRoles(){
        return new ResponseEntity<>(rolRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol>obtenerRol(@PathVariable Long id){
        Rol rol = rolRepository.findById(id).orElseThrow();

        if(rol != null){
            return new ResponseEntity<>(rolRepository.findById(id).orElseThrow(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Rol>guardarRol(@RequestBody Rol rol){
        return new ResponseEntity<>(rolRepository.save(rol), HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>eliminarRol(@PathVariable Long id){
        rolRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol>actualizarRol(@PathVariable Long id, @RequestBody Rol rol){
        Optional<Rol> rolOptional = rolRepository.findById(id);

        if(!rolOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }

        rol.setId(rolOptional.get().getId());
        rolRepository.save(rol);

        return ResponseEntity.noContent().build();
    }



}
