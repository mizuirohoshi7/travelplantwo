package travelplantwo.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import travelplantwo.config.kafka.KafkaProcessor;
import travelplantwo.domain.*;

@Service
public class PlanModelViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private PlanModelRepository planModelRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPlanCreated_then_CREATE_1(
        @Payload PlanCreated planCreated
    ) {
        try {
            if (!planCreated.validate()) return;

            // view 객체 생성
            PlanModel planModel = new PlanModel();
            // view 객체에 이벤트의 Value 를 set 함
            planModel.setId(planCreated.getId());
            planModel.setMemberId(planCreated.getMemberId());
            planModel.setLocation(planCreated.getLocation());
            planModel.setStartDay(planCreated.getStartDay());
            planModel.setEndDay(planCreated.getEndDay());
            planModel.setBudget(planCreated.getBudget());
            planModel.setGroupSize(planCreated.getGroupSize());
            planModel.setDetails(planCreated.getDetails());
            // view 레파지 토리에 save
            planModelRepository.save(planModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPlanUpdated_then_UPDATE_1(
        @Payload PlanUpdated planUpdated
    ) {
        try {
            if (!planUpdated.validate()) return;
            // view 객체 조회
            Optional<PlanModel> planModelOptional = planModelRepository.findById(
                planUpdated.getId()
            );

            if (planModelOptional.isPresent()) {
                PlanModel planModel = planModelOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                planModel.setMemberId(planUpdated.getMemberId());
                planModel.setLocation(planUpdated.getLocation());
                planModel.setStartDay(planUpdated.getStartDay());
                planModel.setEndDay(planUpdated.getEndDay());
                planModel.setBudget(planUpdated.getBudget());
                planModel.setGroupSize(planUpdated.getGroupSize());
                planModel.setDetails(planUpdated.getDetails());
                // view 레파지 토리에 save
                planModelRepository.save(planModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPlanDeleted_then_DELETE_1(
        @Payload PlanDeleted planDeleted
    ) {
        try {
            if (!planDeleted.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            planModelRepository.deleteById(planDeleted.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
