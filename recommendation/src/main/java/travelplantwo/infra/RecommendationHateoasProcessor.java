package travelplantwo.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import travelplantwo.domain.*;

@Component
public class RecommendationHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Recommendation>> {

    @Override
    public EntityModel<Recommendation> process(
        EntityModel<Recommendation> model
    ) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "//require")
                .withRel("/require")
        );

        return model;
    }
}
