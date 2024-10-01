package br.com.senai.delivery.foodsenai.controllers.pedidos;

import br.com.senai.delivery.foodsenai.services.PedidosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class DeletarPedido {

    @Autowired
    private PedidosServices pedidosService;

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        return pedidosService.deleteById(id);
    }
}
