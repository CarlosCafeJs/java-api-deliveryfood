package br.com.senai.delivery.foodsenai.controllers.clientes;

import br.com.senai.delivery.foodsenai.models.ClientesFood;
import br.com.senai.delivery.foodsenai.services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ListarClientes {

    @Autowired
    private ClientesService clientesService;

    @GetMapping
    public List<ClientesFood> findAll() {
        return clientesService.findAll();
    }

    @GetMapping("/{id}")
    public ClientesFood findById(@PathVariable Long id) {
        return clientesService.findById(id).orElseThrow(() -> 
            new RuntimeException("Cliente não encontrado com ID: " + id));
    }
}
