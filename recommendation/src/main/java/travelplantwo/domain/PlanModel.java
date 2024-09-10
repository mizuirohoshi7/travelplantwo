package travelplantwo.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "PlanModel_table")
@Data
public class PlanModel {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long memberId;
    private String location;
    private Date startDay;
    private Date endDay;
    private Integer budget;
    private Integer groupSize;
    private String details;
}
