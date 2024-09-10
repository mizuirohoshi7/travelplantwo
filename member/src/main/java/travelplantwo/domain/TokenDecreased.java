package travelplantwo.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import travelplantwo.domain.*;
import travelplantwo.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class TokenDecreased extends AbstractEvent {

    private Long id;
    private String oauthId;
    private String name;
    private String email;
    private Integer tokenAmount;

    public TokenDecreased(Member aggregate) {
        super(aggregate);
    }

    public TokenDecreased() {
        super();
    }
}
//>>> DDD / Domain Event
