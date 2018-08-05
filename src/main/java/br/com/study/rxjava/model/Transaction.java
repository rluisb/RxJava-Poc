package br.com.study.rxjava.model;

public class Transaction<T> {

    private int codigo;
    private String descricao;
    private Long idTransacao;
    private T transactionData;

    public Transaction() {
    }

    public Transaction(int codigo, String descricao, Long idTransacao, T transactionData) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.idTransacao = idTransacao;
        this.transactionData = transactionData;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(Long idTransacao) {
        this.idTransacao = idTransacao;
    }

    public T getTransactionData() {
        return transactionData;
    }

    public void setTransactionData(T transactionData) {
        this.transactionData = transactionData;
    }
}
