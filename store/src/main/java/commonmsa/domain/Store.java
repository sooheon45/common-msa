package commonmsa.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import commonmsa.StoreApplication;
import commonmsa.domain.PaymentRequested;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Store_table")
@Data
//<<< DDD / Aggregate Root
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @PostPersist
    public void onPostPersist() {
        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        commonmsa.external.ReceivePaymentCommand receivePaymentCommand = new commonmsa.external.ReceivePaymentCommand();
        // mappings goes here
        StoreApplication.applicationContext
            .getBean(commonmsa.external.Service.class)
            .receivePayment(/* get???(), */receivePaymentCommand);

        PaymentRequested paymentRequested = new PaymentRequested(this);
        paymentRequested.publishAfterCommit();
    }

    public static StoreRepository repository() {
        StoreRepository storeRepository = StoreApplication.applicationContext.getBean(
            StoreRepository.class
        );
        return storeRepository;
    }

    //<<< Clean Arch / Port Method
    public static void approvePayment(PaymentApproved paymentApproved) {
        //implement business logic here:

        /** Example 1:  new item 
        Store store = new Store();
        repository().save(store);

        */

        /** Example 2:  finding and process
        

        repository().findById(paymentApproved.get???()).ifPresent(store->{
            
            store // do something
            repository().save(store);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
