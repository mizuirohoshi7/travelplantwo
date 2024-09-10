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
    RecommendationRepository recommendationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='TokenDecreased'"
    )
    public void wheneverTokenDecreased_CreateRecommendation(
        @Payload TokenDecreased tokenDecreased
    ) {
        TokenDecreased event = tokenDecreased;
        System.out.println(
            "\n\n##### listener CreateRecommendation : " +
            tokenDecreased +
            "\n\n"
        );

        // Sample Logic //
        Recommendation.createRecommendation(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
