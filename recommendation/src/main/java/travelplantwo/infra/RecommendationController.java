package travelplantwo.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import travelplantwo.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/recommendations")
@Transactional
public class RecommendationController {

    @Autowired
    RecommendationRepository recommendationRepository;

    @RequestMapping(
        value = "/recommendations/{id}//require",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Recommendation requireRecommendation(
        @PathVariable(value = "id") Long id,
        @RequestBody RequireRecommendationCommand requireRecommendationCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /recommendation/requireRecommendation  called #####"
        );
        Optional<Recommendation> optionalRecommendation = recommendationRepository.findById(
            id
        );

        optionalRecommendation.orElseThrow(() ->
            new Exception("No Entity Found")
        );
        Recommendation recommendation = optionalRecommendation.get();
        recommendation.requireRecommendation(requireRecommendationCommand);

        recommendationRepository.save(recommendation);
        return recommendation;
    }
}
//>>> Clean Arch / Inbound Adaptor
