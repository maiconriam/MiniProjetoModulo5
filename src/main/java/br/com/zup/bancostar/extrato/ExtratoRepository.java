package br.com.zup.bancostar.extrato;

import br.com.zup.bancostar.extrato.dtos.ExtratoDTO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ExtratoRepository extends CrudRepository<Extrato, Integer> {
    @Modifying
    @Query("select new br.com.zup.bancostar.extrato.dtos.ExtratoDTO( op.data_hora_operacao, op.tipo_operacao, op.valor, ex.saldo)" +
            " from br.com.zup.bancostar.extrato.Extrato ex" +
            " inner join br.com.zup.bancostar.conta.Conta c on c.id = ex.conta_id" +
            " inner join br.com.zup.bancostar.operacao.Operacao op on op.id = ex.operacaos_id where c.id = :idConta")
    List<ExtratoDTO> buscaExtrato(@Param("idConta") Integer idConta);

}
