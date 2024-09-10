package travelplantwo.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import travelplantwo.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "recommendations",
    path = "recommendations"
)
public interface RecommendationRepository
    extends PagingAndSortingRepository<Recommendation, Long> {}
