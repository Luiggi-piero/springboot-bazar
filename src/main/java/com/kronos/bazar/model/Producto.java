package com.kronos.bazar.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo_producto;
    private String nombre;
    private String marca;
    private Double costo;
    private Double cantidad_disponible;

    // ManyToMany: 1 producto puede estar en varias ventas
    @ManyToMany(mappedBy = "listaProductos") // mappedBy: indica que es una relación bidireccional y que Producto es el lado inverso de la relación y está mapeado por la lista 'listaProductos' en Venta
    private List<Venta> ventas;


    public Producto() {
    }

    public Producto(Long codigo_producto, String nombre, String marca, Double costo, Double cantidad_disponible) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidad_disponible = cantidad_disponible;
    }
}
