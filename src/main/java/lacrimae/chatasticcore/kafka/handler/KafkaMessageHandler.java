package lacrimae.chatasticcore.kafka.handler;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface KafkaMessageHandler<T> {
    void handleMessage(ConsumerRecord<String, T> message);
}
