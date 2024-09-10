package travelplantwo.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import travelplantwo.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "likes", path = "likes")
public interface LikeRepository
    extends PagingAndSortingRepository<Like, Long> {}
