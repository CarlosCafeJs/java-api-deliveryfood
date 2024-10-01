package br.com.senai.delivery.foodsenai.controllers.pedidos;

import br.com.senai.delivery.foodsenai.models.PedidosFood;
import br.com.senai.delivery.foodsenai.services.PedidosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class ListarPedidos {

    @Autowired
    private PedidosServices pedidosService;

    @GetMapping
    public List<PedidosFood> findAll() {
        return pedidosService.findAll();
    }

    @GetMapping("/{id}")
    public PedidosFood findById(@PathVariable Long id) {
        return pedidosService.findById(id).orElseThrow(() -> 
            new RuntimeException("Pedido não encontrado com ID: " + id));
    }
}
