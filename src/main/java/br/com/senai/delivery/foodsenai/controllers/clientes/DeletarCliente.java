package br.com.senai.delivery.foodsenai.controllers.clientes;

import br.com.senai.delivery.foodsenai.services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class DeletarCliente {

    @Autowired
    private ClientesService clientesService;

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        return clientesService.deleteById(id);
    }
}
