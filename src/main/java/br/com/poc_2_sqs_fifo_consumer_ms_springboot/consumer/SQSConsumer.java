package br.com.poc_2_sqs_fifo_consumer_ms_springboot.consumer;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class SQSConsumer {

    @SqsListener("poc-sqs.fifo")
    public void receiveMessage(String message) {

        System.out.println("Mensagem recebida: " + message);

        if (message.equals("poison message")) {
            throw new RuntimeException("Erro ao processar mensagem");
        }
    }

}

