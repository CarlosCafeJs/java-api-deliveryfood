package br.com.senai.delivery.foodsenai.controllers.products;

import br.com.senai.delivery.foodsenai.models.ProdutosFood;
import br.com.senai.delivery.foodsenai.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ListarProdutos {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutosFood> findAll() {
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    public ProdutosFood findById(@PathVariable Long id) {
        return produtoService.findById(id).orElseThrow(() -> 
            new RuntimeException("Produto não encontrado com ID: " + id));
    }
}
