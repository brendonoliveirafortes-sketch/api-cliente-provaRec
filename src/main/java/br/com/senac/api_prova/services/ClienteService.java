package br.com.senac.api_prova.services;

import br.com.senac.api_prova.dtos.ClienteDTO;
import br.com.senac.api_prova.entidade.ClienteEntidade;
import br.com.senac.api_prova.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public List<ClienteEntidade> listar() {
        return clienteRepositorio.findAll();
    }

    public ClienteEntidade criar(ClienteDTO cliente) {
        this.validarCliente(cliente);

        ClienteEntidade clienteNovo = new ClienteEntidade();
        clienteNovo.setNome(cliente.getNome());
        clienteNovo.setEmail(cliente.getEmail());
        clienteNovo.setDocumento(cliente.getDocumento());


        return clienteRepositorio.save(clienteNovo);

    }

    public ClienteEntidade atualizar(Long id, ClienteDTO cliente) {
        this.validarCliente(cliente);

        Optional<ClienteEntidade> animalretorno =
                clienteRepositorio.findById(id);


        if(animalretorno.isPresent()) {
            ClienteEntidade ClienteNovo = new ClienteEntidade();
            ClienteEntidade clienteNovo = new ClienteEntidade();
            clienteNovo.setNome(cliente.getNome());
            clienteNovo.setEmail(cliente.getEmail());
            clienteNovo.setDocumento(cliente.getDocumento());

            clienteNovo.setId(id);

            return clienteRepositorio.save(clienteNovo);
        }

        throw new RuntimeException("Animal não existe");
    }

    public void deletar(Long id) {
        if(clienteRepositorio.existsById(id)) {
            clienteRepositorio.deleteById(id);
            return;
        }

        throw new RuntimeException("Animal não existe");
    }

    private void validarCliente(ClienteDTO clienteDTO) {
        if (clienteDTO.getNome() == null) {
            throw new RuntimeException("Campo nome é obrigátorio");
        }

        if(clienteDTO.getEmail() == null) {
            throw new RuntimeException("Campo especie é obrigátorio");
        }


        }
    }
