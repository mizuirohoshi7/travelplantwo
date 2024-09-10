package travelplantwo.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import travelplantwo.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "planModels",
    path = "planModels"
)
public interface PlanModelRepository
    extends PagingAndSortingRepository<PlanModel, Long> {}
