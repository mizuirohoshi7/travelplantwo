package travelplantwo.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import travelplantwo.NotificationApplication;
import travelplantwo.domain.NotificationCreated;

@Entity
@Table(name = "Notification_table")
@Data
//<<< DDD / Aggregate Root
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long memberId;

    private String details;

    private Date createdAt;

    @PostPersist
    public void onPostPersist() {
        NotificationCreated notificationCreated = new NotificationCreated(this);
        notificationCreated.publishAfterCommit();
    }

    public static NotificationRepository repository() {
        NotificationRepository notificationRepository = NotificationApplication.applicationContext.getBean(
            NotificationRepository.class
        );
        return notificationRepository;
    }

    //<<< Clean Arch / Port Method
    public static void createNotification(FollowCreated followCreated) {
        //implement business logic here:

        /** Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);

        NotificationCreated notificationCreated = new NotificationCreated(notification);
        notificationCreated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(followCreated.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);

            NotificationCreated notificationCreated = new NotificationCreated(notification);
            notificationCreated.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void createNotification(PlanCreated planCreated) {
        //implement business logic here:

        /** Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);

        NotificationCreated notificationCreated = new NotificationCreated(notification);
        notificationCreated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(planCreated.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);

            NotificationCreated notificationCreated = new NotificationCreated(notification);
            notificationCreated.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
