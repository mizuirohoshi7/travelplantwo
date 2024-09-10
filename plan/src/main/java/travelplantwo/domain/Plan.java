package travelplantwo.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import travelplantwo.PlanApplication;

@Entity
@Table(name = "Plan_table")
@Data
//<<< DDD / Aggregate Root
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long memberId;

    private String location;

    private Date startDay;

    private Date endDay;

    private Integer budget;

    private Integer groupSize;

    private String details;

    public static PlanRepository repository() {
        PlanRepository planRepository = PlanApplication.applicationContext.getBean(
            PlanRepository.class
        );
        return planRepository;
    }
}
//>>> DDD / Aggregate Root
