package br.com.study.rxjava.subscriber;

import br.com.study.rxjava.entity.MessageEntity;
import br.com.study.rxjava.model.MessageTypes;
import br.com.study.rxjava.stream.TransactionSubject;
import org.springframework.stereotype.Component;
import rx.subjects.Subject;

@Component
public class PaymentSubscriber {

    private PaymentSubscriber() {
        Subject transactionSubject = TransactionSubject.getTransactionSubject();
        transactionSubject
                .filter(event -> ((MessageEntity) event).getType().equalsIgnoreCase(MessageTypes.PAGAMENTO_ACEITO))
                .subscribe(event -> {
            MessageEntity oldMessageEntity = (MessageEntity) event;
            MessageEntity newMessageEntity = new MessageEntity(MessageTypes.PAGAMENTO_EM_PROCESSAMENTO, oldMessageEntity.getBody());
            transactionSubject.onNext(newMessageEntity);
        });
    }
}
