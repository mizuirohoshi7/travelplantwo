package travelplantwo.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import travelplantwo.infra.AbstractEvent;

@Data
public class PlanUpdated extends AbstractEvent {

    private Long id;
    private Long memberId;
    private String location;
    private Date startDay;
    private Date endDay;
    private Integer budget;
    private Integer groupSize;
    private String details;
}
