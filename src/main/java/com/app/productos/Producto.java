package com.app.productos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "productos")
@ToString @EqualsAndHashCode
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;
    @Getter @Setter
    @Column(length = 64)
    private String nombre;
    @Getter @Setter
    private float precio;

    public Producto(){};

    public Producto(String nombre,float precio){
        super();
        this.nombre = nombre;
        this.precio = precio;
    }
}
