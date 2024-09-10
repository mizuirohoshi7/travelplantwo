package travelplantwo.domain;

import java.util.*;
import lombok.*;
import travelplantwo.domain.*;
import travelplantwo.infra.AbstractEvent;

@Data
@ToString
public class PlanCreated extends AbstractEvent {

    private Long id;
}
