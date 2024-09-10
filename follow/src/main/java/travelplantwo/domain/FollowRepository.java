package travelplantwo.domain;

import travelplantwo.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel="follows", path="follows")
public interface FollowRepository extends PagingAndSortingRepository<Follow, >{
}