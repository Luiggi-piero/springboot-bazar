package com.kronos.bazar.service;

import com.kronos.bazar.model.Producto;

import java.util.List;

public interface IProductoService {
    public void crearProducto(Producto producto);

    public List<Producto> obtenerProductos();

    public Producto obtenerProductoPorID(Long codigoProducto);

    public void eliminarProducto(Long codigoProducto);

    public Producto editarProducto(Producto producto);
}
