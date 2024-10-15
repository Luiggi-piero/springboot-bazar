package com.kronos.bazar.service;

import com.kronos.bazar.model.Venta;
import com.kronos.bazar.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
