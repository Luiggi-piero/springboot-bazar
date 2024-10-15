package com.kronos.bazar.service;

import com.kronos.bazar.model.Cliente;
import com.kronos.bazar.model.Producto;

import java.util.List;

public interface IClienteService {
    public void crearCliente(Cliente cliente);

    public List<Cliente> obtenerClientes();

    public Cliente obtenerClientePorID(Long codigoCliente);

    public void eliminarCliente(Long codigoCliente);

    public Cliente editarCliente(Cliente cliente);
}
