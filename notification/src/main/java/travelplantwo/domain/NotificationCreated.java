package travelplantwo.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import travelplantwo.domain.*;
import travelplantwo.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class NotificationCreated extends AbstractEvent {

    private Long id;
    private Long memberId;
    private String details;
    private Date createdAt;

    public NotificationCreated(Notification aggregate) {
        super(aggregate);
    }

    public NotificationCreated() {
        super();
    }
}
//>>> DDD / Domain Event
