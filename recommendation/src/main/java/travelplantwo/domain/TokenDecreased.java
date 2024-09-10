package travelplantwo.domain;

import java.util.*;
import lombok.*;
import travelplantwo.domain.*;
import travelplantwo.infra.AbstractEvent;

@Data
@ToString
public class TokenDecreased extends AbstractEvent {

    private Long id;
    private String oauthId;
    private String name;
    private String email;
    private Integer tokenAmount;
}
