package br.com.senai.delivery.foodsenai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.senai.delivery.foodsenai.models.ClientesFood;
import br.com.senai.delivery.foodsenai.repository.ClienteRepository;


@Service
public class ClientesService {

    @Autowired
    private ClienteRepository repositoryclientes;

    public ClientesFood save(ClientesFood cliente){
        return repositoryclientes.save(cliente);
    }

    public List<ClientesFood> findAll(){
        return repositoryclientes.findAll();
    }

    public Optional<ClientesFood> findById(Long id){
        return repositoryclientes.findById(id);
    }

    public String deleteById(Long id){
        if(repositoryclientes.existsById(id)){
            repositoryclientes.deleteById(id);
            return "Deleteado com sucesso!";
        }else{
            return "Erro ao deletar!";
        }
    }

    public ClientesFood update(Long id, ClientesFood cliente) {
    if (repositoryclientes.existsById(id)) {
        cliente.setId(id);
        return repositoryclientes.save(cliente);
    } else {
        throw new RuntimeException("Pedido não encontrado com ID: " + id);
    }

    }
}
