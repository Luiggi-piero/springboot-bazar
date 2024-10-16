package com.kronos.bazar.service;

import com.kronos.bazar.dto.ResumenDiaDTO;
import com.kronos.bazar.dto.VentaMayorTotalDTO;
import com.kronos.bazar.model.Producto;
import com.kronos.bazar.model.Venta;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    public void crearVenta(Venta venta);

    public List<Venta> obtenerVentas();

    public Venta obtenerVentaPorID(Long codigoVenta);

    public void eliminarVenta(Long codigoVenta);

    public Venta editarVenta(Venta venta);

    public List<Producto> listarProductosDeVenta(Long idVenta);

    public ResumenDiaDTO obtenerResumenDia(LocalDate fechaVenta);

    public VentaMayorTotalDTO obtenerVentaConMayorTotal();
}
