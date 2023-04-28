package lacrimae.chatasticcore.kafka.handler;

import lacrimae.chatasticcore.kafka.proto.UserMessageOuterClass.UserMessage;
import lacrimae.chatasticcore.model.User;
import lacrimae.chatasticcore.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class KafkaUserHandler implements KafkaMessageHandler<UserMessage> {

    private final UserRepository userRepository;

    @Override
    public void handleMessage(ConsumerRecord<String, UserMessage> message) {
        UserMessage kafkaUser = message.value();

        User user = User.builder()
                .UUID(kafkaUser.getUuid())
                .nickname(kafkaUser.getNickname())
                .build();

        User persistedUser = userRepository.save(user);
        log.debug("User saved: {}", persistedUser);
    }
}
