package com.example.praticaseara2;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transacao")
public class TransacaoController {
    private final TransacaoRep transactionRep;
    @Autowired
    public TransacaoController(TransacaoRep transactionRep) {
        this.transactionRep = transactionRep;
    }

    @GetMapping("/selecionar")
    public List<Transacao> listarTransactions() {
        return transactionRep.findAll();
    }
//    @GetMapping("/selecionar/{tipo_transacao}")
//    public List<Transacao> listarTransactionsById(PathVariable String){
//        transactionRep.;
//        return ;
//    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluirProduto(@PathVariable Long id) {
        transactionRep.deleteById(id);
        return ResponseEntity.ok("Produto excluido com sucesso");
    }
//    @PutMapping("/atualizar/{id}")
//    public ResponseEntity<String> atualizarProduto(@PathVariable Long id,
//                                                   @RequestBody Transacao transacaoAtualizada){
//        Optional<Transacao> transacaoExistente = transactionRep.findById(id);
//        if(transacaoExistente.isPresent()){
//            Transacao transacao = transacaoExistente.get();
//            Transacao.setDescricao(transacaoAtualizada.getDescricao());
//            Transacao.setValor(transacaoAtualizada.getValor());
//            transactionRep.save(transacao);
//            return ResponseEntity.ok("Produto atualizado com sucesso");
//        }else{
//            return ResponseEntity.notFound().build();
//        }
//    }
    @PostMapping("/inserirForm")
    public ResponseEntity<String> inserirProduto(@RequestParam String descricao,
                                                 @RequestParam double valor,
                                                 @RequestParam Date data_transacao,
                                                 @RequestParam String tipo_transacao){
        Transacao novaTransacao = new Transacao(descricao, valor, data_transacao, tipo_transacao);
        try {
            transactionRep.save(novaTransacao);
            return ResponseEntity.ok("Transacao inserido com sucesso");
        }catch (DataAccessException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao inserir Transacao");
        }
    }
}

