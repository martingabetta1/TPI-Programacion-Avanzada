package com.crudmarca.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="Tecnico", uniqueConstraints=@UniqueConstraint(columnNames={"tecnico_id","tecnico_nombre","tecnico_apellido","tecnico_telefono"}))
@SQLDelete(sql = "UPDATE Tecnico SET eliminado = true WHERE tecnico_id = ?")
@Where(clause = "eliminado = false")
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tecnico_id;
    
    @Size(max = 40)
    @Column(name = "tecnico_nombre",nullable = false)
    private String tecnico_nombre;

    @NotNull
    @NotBlank
    @Size(max = 40)
    @Column(name = "tecnico_apellido")
    private String tecnico_apellido;

    @NotNull
    @NotBlank
    @Size(max = 40)
    @Column(name = "tecnico_telefono", unique = true)
    private String tecnico_telefono;

    @Column(name = "fecha_creacion", updatable= false)
    @CreationTimestamp
    private LocalDateTime fecha_creacion;  

    @Column(name = "fecha_modificacion") 
    @UpdateTimestamp
    private LocalDateTime fecha_modificacion;

    
    private boolean eliminado = Boolean.FALSE;

    public Tecnico(){
        super();
    }

    @Override
    public String toString() {
        return "Tecnico [tecnico_id=" + tecnico_id + ", tecnico_nombre=" + tecnico_nombre + ", fecha_creacion="
                + fecha_creacion + ", fecha_modificacion=" + fecha_modificacion + "]";
    }

    public Integer getTecnico_id() {
        return tecnico_id;
    }

    public void setTecnico_id(Integer tecnico_id) {
        this.tecnico_id = tecnico_id;
    }

    public String getTecnico_nombre() {
        return tecnico_nombre;
    }

    public void setTecnico_nombre(String tecnico_nombre) {
        this.tecnico_nombre = tecnico_nombre;
    }


    public String getTecnico_apellido() {
        return tecnico_apellido;
    }


    public void setTecnico_apellido(String tecnico_apellido) {
        this.tecnico_apellido = tecnico_apellido;
    }


    public String getTecnico_telefono() {
        return tecnico_telefono;
    }


    public void setTecnico_telefono(String tecnico_telefono) {
        this.tecnico_telefono = tecnico_telefono;
    }


    public LocalDateTime getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDateTime fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public LocalDateTime getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(LocalDateTime fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

}
