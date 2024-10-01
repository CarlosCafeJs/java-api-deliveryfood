package br.com.senai.delivery.foodsenai.controllers.clientes;

import br.com.senai.delivery.foodsenai.models.ClientesFood;
import br.com.senai.delivery.foodsenai.services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class AtualizarCliente {

    @Autowired
    private ClientesService clientesService;

    @PutMapping("/{id}")
    public ClientesFood update(@PathVariable Long id, @RequestBody ClientesFood cliente) {
        return clientesService.update(id, cliente);
    }
}
