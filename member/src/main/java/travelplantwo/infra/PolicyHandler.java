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
    MemberRepository memberRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RecommendationRequired'"
    )
    public void wheneverRecommendationRequired_DecreaseToken(
        @Payload RecommendationRequired recommendationRequired
    ) {
        RecommendationRequired event = recommendationRequired;
        System.out.println(
            "\n\n##### listener DecreaseToken : " +
            recommendationRequired +
            "\n\n"
        );

        // Sample Logic //
        Member.decreaseToken(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
