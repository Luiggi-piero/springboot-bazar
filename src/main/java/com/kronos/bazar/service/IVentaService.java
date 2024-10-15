package com.kronos.bazar.service;

import com.kronos.bazar.model.Producto;
import com.kronos.bazar.model.Venta;

import java.util.List;

public interface IVentaService {
    public void crearVenta(Venta venta);

    public List<Venta> obtenerVentas();

    public Venta obtenerVentaPorID(Long codigoVenta);

    public void eliminarVenta(Long codigoVenta);

    public Venta editarVenta(Venta venta);
}
