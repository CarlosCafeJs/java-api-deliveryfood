package br.com.senai.delivery.foodsenai.controllers.products;

import br.com.senai.delivery.foodsenai.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class DeletarProduto {

    @Autowired
    private ProdutoService produtoService;

 

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        produtoService.deleteById(id);
    }
}
