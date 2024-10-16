package com.kronos.bazar.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VentaMayorTotalDTO {
    private Long codigoVenta;
    private Double total;
    private int cantidadProductos;
    private String nombreCliente;
    private String apellidoCliente;

    public VentaMayorTotalDTO() {
    }

    public VentaMayorTotalDTO(Long codigoVenta, Double total, String nombreCliente, int cantidadProductos, String apellidoCliente) {
        this.codigoVenta = codigoVenta;
        this.total = total;
        this.nombreCliente = nombreCliente;
        this.cantidadProductos = cantidadProductos;
        this.apellidoCliente = apellidoCliente;
    }
}
