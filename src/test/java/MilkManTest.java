import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestActorRef;
import hw1.House;
import hw1.MilkMan;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MilkManTest {

    ActorSystem system = ActorSystem.create();

    @Test
    public void wasLastMessageStoredInActor(){
        TestActorRef<MilkMan> actorRef = TestActorRef.create(system, Props.create(MilkMan.class));
        actorRef.tell(new House("craycray", 1), ActorRef.noSender());
        MilkMan elLechero = actorRef.underlyingActor();
        assertEquals(elLechero.getLastDelivery(), 1);
        actorRef.tell(new House("craycray", 2), ActorRef.noSender());
        actorRef.tell(new House("craycray", 3), ActorRef.noSender());
        assertEquals(elLechero.getLastDelivery(), 3);
        assertNotEquals(elLechero.getLastDelivery(), 2);
    }
}
