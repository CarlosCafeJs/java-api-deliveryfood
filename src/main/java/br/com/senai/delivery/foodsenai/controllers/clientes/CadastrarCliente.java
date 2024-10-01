package br.com.senai.delivery.foodsenai.controllers.clientes;

import br.com.senai.delivery.foodsenai.models.ClientesFood;
import br.com.senai.delivery.foodsenai.services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class CadastrarCliente {

    @Autowired
    private ClientesService clientesService;

    @PostMapping
    public ClientesFood save(@RequestBody ClientesFood cliente) {
        return clientesService.save(cliente);
    }
}
