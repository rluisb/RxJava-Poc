package br.com.study.rxjava.repository;

import br.com.study.rxjava.entity.MessageEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends MongoRepository<MessageEntity, String> {

    MessageEntity findMessageEntityByBody_IdTransacao(Long idTransacao);

    MessageEntity insert(MessageEntity messageEntity);
}
