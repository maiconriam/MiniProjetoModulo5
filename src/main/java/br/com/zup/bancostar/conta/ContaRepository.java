package br.com.zup.bancostar.conta;



import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface ContaRepository extends CrudRepository <Conta, Integer> {
    Optional<Conta> findByCpf(String cpf);
    @Modifying
    @Query("update Conta c set c.valor =  c.valor + :valorOperacao where c.id =  :idConta")
    void updateValorConta(@Param("idConta") Integer idConta, @Param("valorOperacao") double valorOperacao);
}
