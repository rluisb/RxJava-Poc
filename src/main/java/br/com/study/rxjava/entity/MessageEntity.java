package br.com.study.rxjava.entity;

import br.com.study.rxjava.model.Message;
import br.com.study.rxjava.model.Transaction;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pagamentos")
public class MessageEntity extends Message<Transaction> {

    @Id
    private String id;

    public MessageEntity(String type, Transaction body) {
        super(type, body);
    }

    public String getId() {
        return id;
    }
}
