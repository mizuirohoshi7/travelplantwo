package travelplantwo.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import travelplantwo.domain.*;

@Component
public class LikeHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Like>> {

    @Override
    public EntityModel<Like> process(EntityModel<Like> model) {
        return model;
    }
}
