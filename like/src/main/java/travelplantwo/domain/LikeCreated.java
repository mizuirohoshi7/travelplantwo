package travelplantwo.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import travelplantwo.domain.*;
import travelplantwo.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class LikeCreated extends AbstractEvent {

    private Long id;
    private Long memberId;
    private Long recommendationId;

    public LikeCreated(Like aggregate) {
        super(aggregate);
    }

    public LikeCreated() {
        super();
    }
}
//>>> DDD / Domain Event
