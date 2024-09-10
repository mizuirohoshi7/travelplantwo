package travelplantwo.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import travelplantwo.domain.*;
import travelplantwo.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class FollowDeleted extends AbstractEvent {

    private Long id;
    private Long fromId;
    private Long toId;

    public FollowDeleted(Follow aggregate) {
        super(aggregate);
    }

    public FollowDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
