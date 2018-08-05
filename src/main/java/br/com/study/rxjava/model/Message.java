package br.com.study.rxjava.model;

import org.springframework.data.mongodb.core.mapping.Field;

public abstract class Message<T> {

    private String type;
    @Field
    private T body;

    public Message(String type, T body) {
        this.type = type;
        this.body = body;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
