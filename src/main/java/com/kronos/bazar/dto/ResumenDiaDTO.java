package com.kronos.bazar.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResumenDiaDTO {
    private Double monto;
    private int cantidadVentas;

    public ResumenDiaDTO() {
    }

    public ResumenDiaDTO(Double monto, int cantidadVentas) {
        this.monto = monto;
        this.cantidadVentas = cantidadVentas;
    }
}
