package br.com.study.rxjava.service;

import br.com.study.rxjava.entity.MessageEntity;
import br.com.study.rxjava.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TransationService {

    @Autowired
    private TransactionRepository transactionRepository;

    public MessageEntity findByIdTransacao(Long idTransacao) {
        return transactionRepository.findMessageEntityByBody_IdTransacao(idTransacao);
    }

    public Boolean insertMessage(MessageEntity payment) {
        return Objects.isNull(transactionRepository.insert(payment));
    }
}
