package travelplantwo.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import travelplantwo.domain.*;
import travelplantwo.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class LikeDeleted extends AbstractEvent {

    private Long id;
    private Long memberId;
    private Long recommendationId;

    public LikeDeleted(Like aggregate) {
        super(aggregate);
    }

    public LikeDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
