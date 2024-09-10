package travelplantwo.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import travelplantwo.config.kafka.KafkaProcessor;
import travelplantwo.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    NotificationRepository notificationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='FollowCreated'"
    )
    public void wheneverFollowCreated_CreateNotification(
        @Payload FollowCreated followCreated
    ) {
        FollowCreated event = followCreated;
        System.out.println(
            "\n\n##### listener CreateNotification : " + followCreated + "\n\n"
        );

        // Sample Logic //
        Notification.createNotification(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PlanCreated'"
    )
    public void wheneverPlanCreated_CreateNotification(
        @Payload PlanCreated planCreated
    ) {
        PlanCreated event = planCreated;
        System.out.println(
            "\n\n##### listener CreateNotification : " + planCreated + "\n\n"
        );

        // Sample Logic //
        Notification.createNotification(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
