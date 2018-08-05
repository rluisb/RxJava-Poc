package br.com.study.rxjava.subscriber;

import br.com.study.rxjava.entity.MessageEntity;
import br.com.study.rxjava.service.TransationService;
import br.com.study.rxjava.stream.TransactionSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rx.subjects.Subject;

@Component
public class TransactionSubscriber {

    @Autowired
    private TransationService transationService;

    private TransactionSubscriber() {
        Subject transactionSubject = TransactionSubject.getTransactionSubject();
        transactionSubject.subscribe(event -> {
            transationService.insertMessage((MessageEntity) event);
        });
    }
}
