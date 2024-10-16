package com.kronos.bazar.repository;

import com.kronos.bazar.model.Producto;
import com.kronos.bazar.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {
    @Query("SELECT v.listaProductos FROM Venta v WHERE v.codigo_venta = :idVenta")
    List<Producto> listarProductosDeVenta(@Param("idVenta") Long idVenta);

    @Query("SELECT v FROM Venta v WHERE v.fecha_venta = :fechaVenta")
    List<Venta> obtenerVentasPorFecha(@Param("fechaVenta") LocalDate fechaVenta);

    @Query("SELECT v FROM Venta v WHERE v.total = (SELECT MAX(v2.total) FROM Venta v2)")
    Venta obtenerVentaConMayorTotal();
}
