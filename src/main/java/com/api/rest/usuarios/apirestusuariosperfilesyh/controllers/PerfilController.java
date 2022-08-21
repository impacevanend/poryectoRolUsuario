package com.api.rest.usuarios.apirestusuariosperfilesyh.controllers;

import com.api.rest.usuarios.apirestusuariosperfilesyh.entity.Perfil;
import com.api.rest.usuarios.apirestusuariosperfilesyh.repository.PerfilRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/perfiles")
public class PerfilController {

    private PerfilRepository perfilRepository;

    public PerfilController(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    @GetMapping
    public ResponseEntity<Collection<Perfil>> listarPerfiles(){
        return new ResponseEntity<>(perfilRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping("/{id}")
    public ResponseEntity<Perfil>obtenerPerfilPorId(@PathVariable Long id){
        Perfil perfil = perfilRepository.findById(id).orElseThrow();
        if(perfil != null){
            return new ResponseEntity<>(perfilRepository.findById(id).orElseThrow(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Perfil>guardarPerfil(@RequestBody Perfil perfil){
        return new ResponseEntity<>(perfilRepository.save(perfil), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>eliminarPerfil(@PathVariable Long id){
        perfilRepository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Perfil>actualizarPerfil(@PathVariable Long id, @RequestBody Perfil perfil){
        Optional<Perfil> perfilOotional = perfilRepository.findById(id);
        if(!perfilOotional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }

        perfil.setId(perfilOotional.get().getId());
        perfilRepository.save(perfil);

        return ResponseEntity.noContent().build();
    }

}
