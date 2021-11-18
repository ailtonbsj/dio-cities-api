package io.github.ailtonbsj.citiesapi.cities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityResource {
    @Autowired
    private CityRepository repository;

    @GetMapping
    public List<City> cities() {
        return repository.findAll();
    }
}
