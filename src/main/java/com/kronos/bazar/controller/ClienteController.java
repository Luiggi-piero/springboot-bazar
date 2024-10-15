package com.kronos.bazar.controller;

import com.kronos.bazar.model.Cliente;
import com.kronos.bazar.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService clienteServ;

    @PostMapping("/clientes/crear")
    public String crearCliente(@RequestBody Cliente cliente){
        clienteServ.crearCliente(cliente);
        return "Cliente creado con éxito";
    }

    @GetMapping("/clientes")
    public List<Cliente> obtenerClientes(){
        List<Cliente> clientes = clienteServ.obtenerClientes();
        return clientes;
    }

    @GetMapping("/clientes/{idCliente}")
    public Cliente obtenerClientePorId(@PathVariable Long idCliente){
        Cliente cliente = clienteServ.obtenerClientePorID(idCliente);
        return cliente;
    }

    @DeleteMapping("/clientes/eliminar/{idCliente}")
    public String eliminarCliente(@PathVariable Long idCliente){
        clienteServ.eliminarCliente(idCliente);
        return "Cliente eliminado con éxito";
    }

    @PutMapping("/clientes/editar/{idCliente}")
    public Cliente editarCliente(@PathVariable Long idCliente, @RequestBody Cliente cliente){
        Cliente c = clienteServ.obtenerClientePorID(idCliente);
        if(c != null){
            return clienteServ.editarCliente(cliente);
        }

        return null;
    }
}
