package travelplantwo.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import travelplantwo.domain.*;
import travelplantwo.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PlanUpdated extends AbstractEvent {

    private Long id;
    private Long memberId;
    private String location;
    private Date startDay;
    private Date endDay;
    private Integer budget;
    private Integer groupSize;
    private String details;

    public PlanUpdated(Plan aggregate) {
        super(aggregate);
    }

    public PlanUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
