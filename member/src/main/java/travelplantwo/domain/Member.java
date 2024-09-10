package travelplantwo.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import travelplantwo.MemberApplication;
import travelplantwo.domain.MemberCreated;
import travelplantwo.domain.TokenDecreased;
import travelplantwo.domain.TokenDecreasingFailed;
import travelplantwo.domain.TokenIncreased;

@Entity
@Table(name = "Member_table")
@Data
//<<< DDD / Aggregate Root
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String oauthId;

    private String name;

    private String email;

    private Integer tokenAmount;

    @PostPersist
    public void onPostPersist() {
        MemberCreated memberCreated = new MemberCreated(this);
        memberCreated.publishAfterCommit();

        TokenDecreased tokenDecreased = new TokenDecreased(this);
        tokenDecreased.publishAfterCommit();

        TokenDecreasingFailed tokenDecreasingFailed = new TokenDecreasingFailed(
            this
        );
        tokenDecreasingFailed.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        TokenIncreased tokenIncreased = new TokenIncreased(this);
        tokenIncreased.publishAfterCommit();
    }

    public static MemberRepository repository() {
        MemberRepository memberRepository = MemberApplication.applicationContext.getBean(
            MemberRepository.class
        );
        return memberRepository;
    }

    //<<< Clean Arch / Port Method
    public static void decreaseToken(
        RecommendationRequired recommendationRequired
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Member member = new Member();
        repository().save(member);

        TokenDecreased tokenDecreased = new TokenDecreased(member);
        tokenDecreased.publishAfterCommit();
        TokenDecreasingFailed tokenDecreasingFailed = new TokenDecreasingFailed(member);
        tokenDecreasingFailed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(recommendationRequired.get???()).ifPresent(member->{
            
            member // do something
            repository().save(member);

            TokenDecreased tokenDecreased = new TokenDecreased(member);
            tokenDecreased.publishAfterCommit();
            TokenDecreasingFailed tokenDecreasingFailed = new TokenDecreasingFailed(member);
            tokenDecreasingFailed.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
