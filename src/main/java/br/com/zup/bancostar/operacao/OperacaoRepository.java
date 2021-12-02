package br.com.zup.bancostar.operacao;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OperacaoRepository extends CrudRepository<Operacao, Integer>{
    List<Operacao> findAllByContaId(Integer id);
}
