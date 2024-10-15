package com.kronos.bazar.service;

import com.kronos.bazar.model.Cliente;
import com.kronos.bazar.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepo;

    @Override
    public void crearCliente(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    @Override
    public List<Cliente> obtenerClientes() {
        return clienteRepo.findAll();
    }

    @Override
    public Cliente obtenerClientePorID(Long codigoCliente) {
        Cliente cliente = clienteRepo.findById(codigoCliente).orElse(null);
        return cliente;
    }

    @Override
    public void eliminarCliente(Long codigoCliente) {
        clienteRepo.deleteById(codigoCliente);
    }

    @Override
    public Cliente editarCliente(Cliente cliente) {
        this.crearCliente(cliente);
        return this.obtenerClientePorID(cliente.getId_cliente());
    }
}
