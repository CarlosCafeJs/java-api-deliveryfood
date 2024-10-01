package br.com.senai.delivery.foodsenai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import br.com.senai.delivery.foodsenai.models.PedidosFood;
import br.com.senai.delivery.foodsenai.repository.PedidoRepository;

@Service
public class PedidosServices {

    @Autowired
    private PedidoRepository repositoryPedido; 

    public PedidosFood save(PedidosFood pedido) {
        return repositoryPedido.save(pedido);
    }

    public List<PedidosFood> findAll() {
        return repositoryPedido.findAll();
    }

    public Optional<PedidosFood> findById(Long id) {
        return repositoryPedido.findById(id);
    }

    public String deleteById(Long id) {
        if (repositoryPedido.existsById(id)) {
            repositoryPedido.deleteById(id);
            return "Pedido deletado com sucesso!";
        } else {
            return "Erro ao deletar!";
        }
    }

    public PedidosFood update(Long id, PedidosFood pedido) {
        if (repositoryPedido.existsById(id)) {
            PedidosFood existingPedido = repositoryPedido.findById(id).orElseThrow(() ->
                    new RuntimeException("Pedido não encontrado com ID: " + id));
            
            existingPedido.setStatus(pedido.getStatus());
            existingPedido.setValorTotal(pedido.getValorTotal());
            
            return repositoryPedido.save(existingPedido);
        } else {
            throw new RuntimeException("Pedido não encontrado com ID: " + id);
        }
    }
}
