package lacrimae.chatasticcore.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
public class Message {
//    private Long id;
//    private String receiver;
//    private String sender;
    private String content;
//    private Date sentAt;
}
