package br.com.senai.delivery.foodsenai.controllers.pedidos;

import br.com.senai.delivery.foodsenai.models.PedidosFood;
import br.com.senai.delivery.foodsenai.services.PedidosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class AtualizarPedido {

    @Autowired
    private PedidosServices pedidosService;

    @PutMapping("/{id}")
    public PedidosFood update(@PathVariable Long id, @RequestBody PedidosFood pedido) {
        return pedidosService.update(id, pedido);
    }
}
