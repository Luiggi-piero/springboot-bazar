package com.kronos.bazar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo_venta;

    private LocalDate fecha_venta;
    private Double total;

    @ManyToMany // 1 venta tiene una lista de productos
    @JsonIgnoreProperties("ventas")  // Ignora la propiedad ventas de cada producto
    @JoinTable( // Personalizando la tabla intermedia
            name = "venta_producto",   // nombre de la tabla
            joinColumns = @JoinColumn(name = "venta_id"),  // nombre de la columna (FK) de venta
            inverseJoinColumns = @JoinColumn(name = "producto_id") // nombre de la columna (FK) de producto
    )
    private List<Producto> listaProductos;
//    @OneToMany
//    private List<Producto> listaProductos;

    @OneToOne
    @JoinColumn(name = "un_cliente_id_cliente", referencedColumnName = "id_cliente")
    private Cliente unCliente;

    public Venta() {
    }

    public Venta(Long codigo_venta, LocalDate fecha_venta, Double total, List<Producto> listaProductos, Cliente unCliente) {
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.listaProductos = listaProductos;
        this.unCliente = unCliente;
    }
}
