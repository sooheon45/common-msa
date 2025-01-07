package commonmsa.domain;

import commonmsa.domain.*;
import commonmsa.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PaymentRequested extends AbstractEvent {

    private Long id;
    private String amount;

    public PaymentRequested(Store aggregate) {
        super(aggregate);
    }

    public PaymentRequested() {
        super();
    }
}
//>>> DDD / Domain Event
