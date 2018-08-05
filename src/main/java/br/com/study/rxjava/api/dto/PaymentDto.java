package br.com.study.rxjava.api.dto;

public class PaymentDto {

    private String nsuOrigem;
    private String data;
    private Integer idConta;
    private String cpf;
    private Double valor;

    public PaymentDto() {
    }

    public PaymentDto(String nsuOrigem, String data, Integer idConta, String cpf, Double valor) {
        this.nsuOrigem = nsuOrigem;
        this.data = data;
        this.idConta = idConta;
        this.cpf = cpf;
        this.valor = valor;
    }

    public String getNsuOrigem() {
        return nsuOrigem;
    }

    public void setNsuOrigem(String nsuOrigem) {
        this.nsuOrigem = nsuOrigem;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getIdConta() {
        return idConta;
    }

    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
