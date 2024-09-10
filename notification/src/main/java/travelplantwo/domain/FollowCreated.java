package travelplantwo.domain;

import java.util.*;
import lombok.*;
import travelplantwo.domain.*;
import travelplantwo.infra.AbstractEvent;

@Data
@ToString
public class FollowCreated extends AbstractEvent {

    private Long id;
    private Long fromId;
    private Long toId;
}
