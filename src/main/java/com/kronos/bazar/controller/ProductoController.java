package com.kronos.bazar.controller;

import com.kronos.bazar.model.Producto;
import com.kronos.bazar.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService productoServ;

    @PostMapping("/productos/crear")
    public String crearProducto(@RequestBody Producto producto){
        productoServ.crearProducto(producto);
        return "Producto creado con éxito";
    }

    @GetMapping("/productos")
    public List<Producto> obtenerProductos(){
        return productoServ.obtenerProductos();
    }

    @GetMapping("/productos/{codigoProducto}")
    public Producto obtenerProductoPorId(@PathVariable Long codigoProducto){
        Producto producto = productoServ.obtenerProductoPorID(codigoProducto);
        return producto;
    }

    @DeleteMapping("/productos/eliminar/{codigoProducto}")
    public String eliminarProducto(@PathVariable Long codigoProducto){
        productoServ.eliminarProducto(codigoProducto);
        return "Producto eliminado con éxito";
    }

    @PutMapping("/productos/editar/{codigoProducto}")
    public Producto editarProducto(@PathVariable Long codigoProducto, @RequestBody Producto producto){
        Producto p = productoServ.obtenerProductoPorID(codigoProducto);
        if(p != null){
            return productoServ.editarProducto(producto);
        }
        return null;
    }

    @GetMapping("/productos/falta_stock/{cantidad}")
    public List<Producto> productosCantidadMenor(@PathVariable int cantidad){
        return productoServ.productosCantidadMenor(cantidad);
    }
}
