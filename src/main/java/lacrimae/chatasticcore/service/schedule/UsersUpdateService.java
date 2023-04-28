package lacrimae.chatasticcore.service.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
@Transactional
public class UsersUpdateService {

    @Scheduled()
    public void updateUsers() {
        log.info(
                "Scheduled user updating has started at: {}",
                LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME)
        );



    }
}
