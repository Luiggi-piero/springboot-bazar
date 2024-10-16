package com.kronos.bazar.service;

import com.kronos.bazar.dto.ResumenDiaDTO;
import com.kronos.bazar.dto.VentaMayorTotalDTO;
import com.kronos.bazar.model.Producto;
import com.kronos.bazar.model.Venta;
import com.kronos.bazar.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository ventaRepo;

    @Override
    public void crearVenta(Venta venta) {
        ventaRepo.save(venta);
    }

    @Override
    public List<Venta> obtenerVentas() {
        return ventaRepo.findAll();
    }

    @Override
    public Venta obtenerVentaPorID(Long codigoVenta) {
        Venta venta = ventaRepo.findById(codigoVenta).orElse(null);
        return venta;
    }

    @Override
    public void eliminarVenta(Long codigoVenta) {
        ventaRepo.deleteById(codigoVenta);
    }

    @Override
    public Venta editarVenta(Venta venta) {
        this.crearVenta(venta);
        return this.obtenerVentaPorID(venta.getCodigo_venta());
    }

    @Override
    public List<Producto> listarProductosDeVenta(Long idVenta) {
        return ventaRepo.listarProductosDeVenta(idVenta);
    }

    @Override
    public ResumenDiaDTO obtenerResumenDia(LocalDate fechaVenta) {
        List<Venta> ventas = ventaRepo.obtenerVentasPorFecha(fechaVenta);
        ResumenDiaDTO resumenDia = new ResumenDiaDTO();
        Double total = 0.0;

        for (Venta venta: ventas){
            total += venta.getTotal();
        }

        resumenDia.setMonto(total);
        resumenDia.setCantidadVentas(ventas.size());
        return resumenDia;
    }

    @Override
    public VentaMayorTotalDTO obtenerVentaConMayorTotal() {
        Venta venta = ventaRepo.obtenerVentaConMayorTotal();
        VentaMayorTotalDTO ventaMayor = new VentaMayorTotalDTO();

        ventaMayor.setCodigoVenta(venta.getCodigo_venta());
        ventaMayor.setTotal(venta.getTotal());
        ventaMayor.setCantidadProductos(venta.getListaProductos().size());
        ventaMayor.setNombreCliente(venta.getUnCliente().getNombre());
        ventaMayor.setApellidoCliente(venta.getUnCliente().getApellido());
        return ventaMayor;
    }
}
