package travelplantwo.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import travelplantwo.domain.*;
import travelplantwo.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class TokenDecreasingFailed extends AbstractEvent {

    private Long id;
    private String oauthId;
    private String name;
    private String email;
    private Integer tokenAmount;

    public TokenDecreasingFailed(Member aggregate) {
        super(aggregate);
    }

    public TokenDecreasingFailed() {
        super();
    }
}
//>>> DDD / Domain Event
