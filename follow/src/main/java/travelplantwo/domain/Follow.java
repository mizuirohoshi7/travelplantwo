package travelplantwo.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import travelplantwo.FollowApplication;
import travelplantwo.domain.FollowCreated;
import travelplantwo.domain.FollowDeleted;

@Entity
@Table(name = "Follow_table")
@Data
//<<< DDD / Aggregate Root
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long fromId;

    private Long toId;

    @PostPersist
    public void onPostPersist() {
        FollowCreated followCreated = new FollowCreated(this);
        followCreated.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {
        FollowDeleted followDeleted = new FollowDeleted(this);
        followDeleted.publishAfterCommit();
    }

    public static FollowRepository repository() {
        FollowRepository followRepository = FollowApplication.applicationContext.getBean(
            FollowRepository.class
        );
        return followRepository;
    }
}
//>>> DDD / Aggregate Root
