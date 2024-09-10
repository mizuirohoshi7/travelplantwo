package travelplantwo.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import travelplantwo.domain.*;
import travelplantwo.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class RecommendationCreated extends AbstractEvent {

    private Long id;
    private Long memberId;
    private String contents;
    private String type;

    public RecommendationCreated(Recommendation aggregate) {
        super(aggregate);
    }

    public RecommendationCreated() {
        super();
    }
}
//>>> DDD / Domain Event
