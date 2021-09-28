package by.epam.pipeline;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding({Sink.class, KafkaProcessor.class})
public class Consumer {

    @StreamListener(Sink.INPUT)
    @SendTo(KafkaProcessor.OUTPUT)
    public String streamFromRabbitToKafka(String str) {
        System.out.println("Receive message: " + str);
        return str;
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void logKafka(String str) {
        System.out.println("Received from kafka: " + str);
    }
}
