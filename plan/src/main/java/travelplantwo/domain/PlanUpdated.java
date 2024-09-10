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

    public PlanUpdated(Plan aggregate) {
        super(aggregate);
    }

    public PlanUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
