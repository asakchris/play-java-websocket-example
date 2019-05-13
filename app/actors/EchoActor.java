package actors;

import akka.actor.AbstractLoggingActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import stocks.Request;

public class EchoActor extends AbstractLoggingActor {
    private ActorRef out;

    public EchoActor(ActorRef out) {
        this.out = out;
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, message -> {
                    log().info("Received String message: {}", message);
                    out.tell(message, self());
                })
                .match(Request.class, rqst -> {
                    log().info("Received Request message: {}", rqst);
                    out.tell(rqst.getMessage(), self());
                })
                .match(Object.class, obj -> {
                    log().info("Received Object message: {}", obj);
                    out.tell(obj, self());
                })
                .build();
    }

    public static Props props(ActorRef out) {
        return Props.create(EchoActor.class, out);
    }
}
