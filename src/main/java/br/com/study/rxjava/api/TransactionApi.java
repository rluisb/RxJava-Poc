package br.com.study.rxjava.api;

import br.com.study.rxjava.api.dto.PaymentDto;
import br.com.study.rxjava.entity.MessageEntity;
import br.com.study.rxjava.model.MessageTypes;
import br.com.study.rxjava.service.TransationService;
import br.com.study.rxjava.stream.TransactionSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.study.rxjava.model.Transaction;

import javax.ws.rs.PathParam;
import java.util.Objects;

@RestController
public class TransactionApi {

    @Autowired
    private TransationService transationService;

    @PostMapping(value = "/v1/api/transacao/pagamento")
    public ResponseEntity<?> requestPayment(@RequestBody PaymentDto paymentDto) {
        if (Objects.isNull(paymentDto)) {
            return ResponseEntity.badRequest().body("Erro");
        }

        Transaction<PaymentDto> transaction = new Transaction(0, "OK", 123456789L, paymentDto);
        MessageEntity messageEntity = new MessageEntity(MessageTypes.PAGAMENTO_ACEITO, transaction);

        TransactionSubject.getTransactionSubject().onNext(messageEntity);

        return ResponseEntity.accepted().body(transaction);
    }

    @GetMapping(value = "/v1/api/transacao/status/{id}")
    public ResponseEntity<?> getTransactionStatus (@PathVariable() Long id) {
        MessageEntity messageEntity = transationService.findByIdTransacao(id);
        return ResponseEntity.ok(messageEntity);
    }
}
