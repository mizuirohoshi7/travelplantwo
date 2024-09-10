package travelplantwo.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import travelplantwo.domain.*;
import travelplantwo.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PlanDeleted extends AbstractEvent {

    public PlanDeleted(Plan aggregate) {
        super(aggregate);
    }

    public PlanDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
