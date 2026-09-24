package br.com.senac.api_prova.repositorio;

import br.com.senac.api_prova.entidade.ClienteEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio
        extends JpaRepository<ClienteEntidade, Long> {
    }
