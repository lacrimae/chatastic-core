package lacrimae.chatasticcore.kafka.listener;

import lacrimae.chatasticcore.kafka.handler.KafkaMessageHandler;
import lacrimae.chatasticcore.kafka.proto.UserMessageOuterClass.UserMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@ConditionalOnExpression("${kafka.enabled:true} and ${topic.user.enabled:true}")
@RequiredArgsConstructor
@Service
@Slf4j
public class KafkaUserListener {

    private final KafkaMessageHandler<UserMessage> handler;

    @KafkaListener(topicPartitions = {
            @TopicPartition(topic = "${topic.user.name}",
                    partitionOffsets = @PartitionOffset(
                            partition = "0",
                            initialOffset = "${topic.user.offset.0}",
                            relativeToCurrent = "true"
                    )
            )
    },
            containerFactory = "concurrentKafkaListenerContainerFactory")
    public void listenToUser(ConsumerRecord<String, UserMessage> record) {
        handler.handleMessage(record);
    }
}
