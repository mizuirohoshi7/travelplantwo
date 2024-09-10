package travelplantwo.domain;

import travelplantwo.domain.PlanCreated;
import travelplantwo.domain.PlanUpdated;
import travelplantwo.domain.PlanDeleted;
import travelplantwo.PlanApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;
import java.time.LocalDate;


@Entity
@Table(name="Plan_table")
@Data

//<<< DDD / Aggregate Root
public class Plan  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    private Long id;
    
    
    
    
    private Long memberId;
    
    
    
    
    private String location;
    
    
    
    
    private Date startDay;
    
    
    
    
    private Date endDay;
    
    
    
    
    private Integer budget;
    
    
    
    
    private Integer groupSize;
    
    
    
    
    private String details;

    @PostPersist
    public void onPostPersist(){


        PlanCreated planCreated = new PlanCreated(this);
        planCreated.publishAfterCommit();

    
    }
    @PostUpdate
    public void onPostUpdate(){


        PlanUpdated planUpdated = new PlanUpdated(this);
        planUpdated.publishAfterCommit();

    
    }
    @PreRemove
    public void onPreRemove(){


        PlanDeleted planDeleted = new PlanDeleted(this);
        planDeleted.publishAfterCommit();

    
    }

    public static PlanRepository repository(){
        PlanRepository planRepository = PlanApplication.applicationContext.getBean(PlanRepository.class);
        return planRepository;
    }

    public void require recommendation(){
        //
    }
    public void require recommendation(){
        //
    }
    public void require recommendation(){
        //
    }





}
//>>> DDD / Aggregate Root
