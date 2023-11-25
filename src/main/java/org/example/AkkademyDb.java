package org.example;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;
import org.example.SetRequest;
import java.util.HashMap;
import java.util.Map;
public class AkkademyDb extends AbstractActor {
    protected final LoggingAdapter log = Logging.getLogger(context().system(), this);
    public final Map<String, Object> map = new HashMap<>();
    private AkkademyDb(){
// this is for the old heads we don't need this
        //        receive(ReceiveBuilder.
//                match(SetRequest.class, message -> {
//                    log.info("Received Set request: {}", message);
//                    map.put(message.getKey(), message.getValue());
//                }).
//                matchAny(o -> log.info("received unknown message: {}", o)).build()
//        );

    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(SetRequest.class, message -> {
                    log.info("Received set request – key: {} value: {}", message.getKey(), message.getValue());
                    map.put(message.getKey(), message.getValue());
                })
                .matchAny(o -> log.info("received unknown message {}", o)).build();
    }
}
