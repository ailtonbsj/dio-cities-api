package io.github.ailtonbsj.citiesapi.countries;

import io.github.ailtonbsj.citiesapi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
