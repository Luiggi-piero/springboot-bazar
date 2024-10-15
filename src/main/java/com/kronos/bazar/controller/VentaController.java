package com.kronos.bazar.controller;

import com.kronos.bazar.model.Venta;
import com.kronos.bazar.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VentaController {

    @Autowired
    private IVentaService ventaServ;

    @PostMapping("/ventas/crear")
    public String crearVenta(@RequestBody Venta venta){
        ventaServ.crearVenta(venta);
        return "Venta creada con éxito";
    }

    @GetMapping("/ventas")
    public List<Venta> obtenerVentas(){
        return ventaServ.obtenerVentas();
    }

    @GetMapping("/ventas/{codigoVenta}")
    public Venta obtenerVentaPorId(@PathVariable Long codigoVenta){
        return ventaServ.obtenerVentaPorID(codigoVenta);
    }

    @DeleteMapping("/ventas/eliminar/{codigoVenta}")
    public String eliminarVenta(@PathVariable Long codigoVenta){
        ventaServ.eliminarVenta(codigoVenta);
        return "Venta eliminada con éxito";
    }

    @PutMapping("/ventas/editar/{codigoVenta}")
    public Venta editarVenta(@PathVariable Long codigoVenta, @RequestBody Venta venta){
        Venta v = this.obtenerVentaPorId(codigoVenta);

        if(v == null){
            return null;
        }

        return ventaServ.editarVenta(venta);
    }
}
