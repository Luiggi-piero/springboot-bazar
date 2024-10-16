package com.kronos.bazar.controller;

import com.kronos.bazar.dto.ResumenDiaDTO;
import com.kronos.bazar.dto.VentaMayorTotalDTO;
import com.kronos.bazar.model.Producto;
import com.kronos.bazar.model.Venta;
import com.kronos.bazar.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping("/ventas/productos/{idVenta}")
    public List<Producto> listarProductosDeVenta(@PathVariable Long idVenta){
        return ventaServ.listarProductosDeVenta(idVenta);
    }

    @GetMapping("/ventas/fecha/{fechaVenta}")
    public ResumenDiaDTO obtenerResumenDia(@PathVariable("fechaVenta") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaVenta){
        return ventaServ.obtenerResumenDia(fechaVenta);
    }

    @GetMapping("/ventas/mayor_venta")
    public VentaMayorTotalDTO obtenerVentaConMayorTotal(){
        return ventaServ.obtenerVentaConMayorTotal();
    }
}
