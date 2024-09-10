package travelplantwo.domain;

import java.util.*;
import lombok.*;
import travelplantwo.domain.*;
import travelplantwo.infra.AbstractEvent;

@Data
@ToString
public class PlanCreated extends AbstractEvent {

    private Long id;
    private Long memberId;
    private String location;
    private Date startDay;
    private Date endDay;
    private Integer budget;
    private Integer groupSize;
    private String details;
}
