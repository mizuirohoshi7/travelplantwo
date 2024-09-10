package travelplantwo.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import travelplantwo.LikeApplication;
import travelplantwo.domain.LikeCreated;
import travelplantwo.domain.LikeDeleted;

@Entity
@Table(name = "Like_table")
@Data
//<<< DDD / Aggregate Root
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long memberId;

    private Long recommendationId;

    @PostPersist
    public void onPostPersist() {
        LikeCreated likeCreated = new LikeCreated(this);
        likeCreated.publishAfterCommit();

        LikeDeleted likeDeleted = new LikeDeleted(this);
        likeDeleted.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {}

    public static LikeRepository repository() {
        LikeRepository likeRepository = LikeApplication.applicationContext.getBean(
            LikeRepository.class
        );
        return likeRepository;
    }
}
//>>> DDD / Aggregate Root
