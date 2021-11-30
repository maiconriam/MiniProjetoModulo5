package br.com.zup.bancostar.conta;



import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface ContaRepository extends CrudRepository <Conta, Integer> {
    Optional<Conta> findByUsuarioCpf(String cpf);

}
