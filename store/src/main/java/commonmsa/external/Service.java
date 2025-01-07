package commonmsa.external;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Date;
@FeignClient(name = "", url = "${api.url.undefined}")
public interface Service {
    @RequestMapping(method= RequestMethod.POST, path="//{id}//receivepayment")
    public void receivePayment(@PathVariable("id")   , @RequestBody ReceivePaymentCommand receivePaymentCommand );
    @RequestMapping(method= RequestMethod.POST, path="//{id}//sendmessage")
    public void sendMessage(@PathVariable("id")   , @RequestBody SendMessageCommand sendMessageCommand );
}