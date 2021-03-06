package com.scuti.predictive.controller.recommendation;

import com.scuti.predictive.model.Product;
import com.scuti.predictive.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;

/**
 * Created by kkataria on 8/21/2016.
 */

@RestController
public class RecommendationAPIController {

    @Autowired
    SearchRepository productSearchRepository;

    @RequestMapping(value = "/{org}/recommend" , method = RequestMethod.GET , produces = "application/json")
    public Collection<Product> recommend(@PathVariable("org") String name) {
        return  productSearchRepository.searchOrgProducts(name);
    }

    @RequestMapping(value = "/{org}/recommendation" , method = RequestMethod.GET , produces = "application/json")
    public Collection<Product> recommendation(@PathVariable("org") String name) {
        

        return  productSearchRepository.searchOrgProducts(name);
    }


}
