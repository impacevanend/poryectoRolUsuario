package com.api.rest.usuarios.apirestusuariosperfilesyh.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;


    private String codigoRol;


    private String nombreRol;

    @ManyToMany
    @JoinTable(name = "rol_usuario",
            joinColumns = @JoinColumn(name = "role_id",
                    referencedColumnName = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id",
                    referencedColumnName = "usuario_id"))

    private Set<Usuario> usuarios = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoRol() {
        return codigoRol;
    }

    public void setCodigoRol(String codigoRol) {
        this.codigoRol = codigoRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
