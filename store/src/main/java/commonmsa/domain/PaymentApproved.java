package commonmsa.domain;

import commonmsa.domain.*;
import commonmsa.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class PaymentApproved extends AbstractEvent {

    private Long id;
    private Integer amount;
    private Date issuedDate;
    private Date approvalDate;
}
