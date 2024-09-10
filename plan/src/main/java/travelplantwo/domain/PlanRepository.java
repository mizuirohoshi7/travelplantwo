package travelplantwo.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import travelplantwo.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "plans", path = "plans")
public interface PlanRepository
    extends PagingAndSortingRepository<Plan, Long> {}
