package krutakod.company.krutakodserver.rest;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import krutakod.company.krutakodserver.googleservice.GooglePlayService;
import krutakod.company.krutakodserver.model.Theme;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
@Slf4j
@RestController
@RequestMapping(value = "/api/v1/subscription")
public class SubscriptionController {
    private GooglePlayService googlePlayService;
    private String packageName="com.krutakod.javaless";
    private String productId="krutasub";
    private Gson gson = new Gson();

    public SubscriptionController() {
        googlePlayService=new GooglePlayService();
    }


    @GetMapping("token/{tokenParch}")
    public String subscriptionValidate(@PathVariable("tokenParch") String token,
                                       @RequestHeader Map<String, String> headers) {
        log.info("Real token: "+token);
        String req = "{\"status\":false}";
        if (headers.get("key").equals("cfylfkm12")) {
            try {
                req = googlePlayService.getSubscription(packageName, productId, token).toString();
                log.info("req is normal: "+req);
               // return req;
            } catch (Exception e) {
                e.printStackTrace();
                log.info("req is not normal: "+req);
                return req;
            }
        }
//        JsonObject jsonSub = gson.fromJson(req,JsonObject.class);
//        if(jsonSub.has("acknowledgementState")){
////            if(jsonSub.get("autoRenewing").getAsBoolean()==false){
////                long timeNow = System.currentTimeMillis();
////                log.info("timeNow = "+timeNow+" expiryTimeMillis"+jsonSub.get("expiryTimeMillis").getAsLong());
////                if(timeNow>jsonSub.get("expiryTimeMillis").getAsLong()){
////                    req = "{\"status\":false}";
////                }
////            }
//
//        }
        log.info("Final req: "+req);
        return req;
    }
    //getSubscription


}
