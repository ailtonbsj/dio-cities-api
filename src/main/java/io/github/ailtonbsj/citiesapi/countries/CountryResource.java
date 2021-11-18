package io.github.ailtonbsj.citiesapi.countries;

import io.github.ailtonbsj.citiesapi.countries.Country;
import io.github.ailtonbsj.citiesapi.countries.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryResource {
    @Autowired
    private CountryRepository repository;

    // http://localhost:8080/countries?page=0&size=10&sort=name,asc
    @GetMapping
    public Page<Country> countries(Pageable page) {
        return repository.findAll(page);
    }

    // http://localhost:8080/countries/1
    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id) {
        Optional<Country> optional = repository.findById(id);
        if(optional.isPresent()) {
            return ResponseEntity.ok().body(optional.get());
        }
        return ResponseEntity.notFound().build();
    }

}
