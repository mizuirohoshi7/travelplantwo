package travelplantwo.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import travelplantwo.RecommendationApplication;

@Entity
@Table(name = "Recommendation_table")
@Data
//<<< DDD / Aggregate Root
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long memberId;

    private String contents;

    private String type;

    public static RecommendationRepository repository() {
        RecommendationRepository recommendationRepository = RecommendationApplication.applicationContext.getBean(
            RecommendationRepository.class
        );
        return recommendationRepository;
    }

    //<<< Clean Arch / Port Method
    public void requireRecommendation(
        RequireRecommendationCommand requireRecommendationCommand
    ) {
        //implement business logic here:

        RecommendationRequired recommendationRequired = new RecommendationRequired(
            this
        );
        recommendationRequired.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void createRecommendation(TokenDecreased tokenDecreased) {

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
