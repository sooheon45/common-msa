package commonmsa.external;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
public class SendMessageCommand {

    @Id
    private String type;

    private String number;
}
