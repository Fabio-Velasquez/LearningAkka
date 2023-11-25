package hw1;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import hw1.House;

public class MilkMan extends AbstractActor {
    private int lastDelivery;
    protected  final LoggingAdapter log = Logging.getLogger(context().system(), this);
    @Override
    public Receive createReceive() {
        return receiveBuilder().match(House.class, message ->{
            log.info("Milk was delivered to house {} and the number of milk that was delivered was {}", message.getAddy(), message.getMilkDelivered());
            this.setLastDelivery(message.getMilkDelivered());
        })
        .matchAny(o -> log.info("unkown message {} ", o))
        .build();
    }

    public void setLastDelivery(int lastDelivery) {
        this.lastDelivery = lastDelivery;
    }

    public int getLastDelivery() {
        return lastDelivery;
    }
}
