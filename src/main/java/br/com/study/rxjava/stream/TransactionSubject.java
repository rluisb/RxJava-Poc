package br.com.study.rxjava.stream;

import org.springframework.stereotype.Component;
import rx.subjects.PublishSubject;

import javax.annotation.PostConstruct;

@Component
public class TransactionSubject {

    private static PublishSubject transactionSubject;

    @PostConstruct
    public void bootstrap() {
        this.transactionSubject = PublishSubject.create();
    }

    public static PublishSubject getTransactionSubject() {
        return transactionSubject;
    }

}
