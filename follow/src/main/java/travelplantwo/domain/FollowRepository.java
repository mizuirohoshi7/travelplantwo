package travelplantwo.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import travelplantwo.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "follows", path = "follows")
public interface FollowRepository
    extends PagingAndSortingRepository<Follow, Long> {}
