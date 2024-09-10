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
public class PlanViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private PlanRepository planRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPlanCreated_then_CREATE_1(
        @Payload PlanCreated planCreated
    ) {
        try {
            if (!planCreated.validate()) return;

            // view 객체 생성
            Plan plan = new Plan();
            // view 객체에 이벤트의 Value 를 set 함
            plan.setId(planCreated.getId());
            plan.setMemberId(planCreated.getMemberId());
            plan.setLocation(planCreated.getLocation());
            plan.setStartDay(planCreated.getStartDay());
            plan.setEndDay(planCreated.getEndDay());
            plan.setBudget(planCreated.getBudget());
            plan.setGroupSize(planCreated.getGroupSize());
            plan.setDetails(planCreated.getDetails());
            // view 레파지 토리에 save
            planRepository.save(plan);
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
            Optional<Plan> planOptional = planRepository.findById(
                planUpdated.getId()
            );

            if (planOptional.isPresent()) {
                Plan plan = planOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                plan.setMemberId(planUpdated.getMemberId());
                plan.setLocation(planUpdated.getLocation());
                plan.setStartDay(planUpdated.getStartDay());
                plan.setEndDay(planUpdated.getEndDay());
                plan.setBudget(planUpdated.getBudget());
                plan.setGroupSize(planUpdated.getGroupSize());
                plan.setDetails(planUpdated.getDetails());
                // view 레파지 토리에 save
                planRepository.save(plan);
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
            planRepository.deleteById(planDeleted.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
