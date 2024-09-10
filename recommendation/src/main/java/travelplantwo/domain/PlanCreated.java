package travelplantwo.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import travelplantwo.infra.AbstractEvent;

@Data
public class PlanCreated extends AbstractEvent {

    private Long id;
}
