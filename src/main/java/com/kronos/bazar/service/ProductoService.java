package com.kronos.bazar.service;

import com.kronos.bazar.model.Producto;
import com.kronos.bazar.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository productoRepo;

    @Override
    public void crearProducto(Producto producto) {
        productoRepo.save(producto);
    }

    @Override
    public List<Producto> obtenerProductos() {
        List<Producto> productos = productoRepo.findAll();
        return productos;
    }

    @Override
    public Producto obtenerProductoPorID(Long codigoProducto) {
        Producto producto = productoRepo.findById(codigoProducto).orElse(null);
        return producto;
    }

    @Override
    public void eliminarProducto(Long codigoProducto) {
        productoRepo.deleteById(codigoProducto);
    }

    @Override
    public Producto editarProducto(Producto producto) {
        this.crearProducto(producto);
        return this.obtenerProductoPorID(producto.getCodigo_producto());
    }

    @Override
    public List<Producto> productosCantidadMenor(int cantidad) {
        return productoRepo.productosCantidadMenor(cantidad);
    }
}
