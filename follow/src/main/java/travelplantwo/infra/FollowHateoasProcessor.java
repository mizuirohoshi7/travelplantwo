package travelplantwo.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import travelplantwo.domain.*;

@Component
public class FollowHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Follow>> {

    @Override
    public EntityModel<Follow> process(EntityModel<Follow> model) {
        return model;
    }
}
