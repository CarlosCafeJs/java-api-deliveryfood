package br.com.senai.delivery.foodsenai.controllers.products;

import br.com.senai.delivery.foodsenai.models.ProdutosFood;
import br.com.senai.delivery.foodsenai.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class CadastrarProduto {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ProdutosFood save(@RequestBody ProdutosFood produto) {
        return produtoService.save(produto);
    }
}
