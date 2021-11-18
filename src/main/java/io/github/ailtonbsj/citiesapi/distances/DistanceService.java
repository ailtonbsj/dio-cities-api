package io.github.ailtonbsj.citiesapi.distances;

import io.github.ailtonbsj.citiesapi.cities.City;
import io.github.ailtonbsj.citiesapi.cities.CityRepository;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DistanceService {
    private final CityRepository cityRepository;

    public DistanceService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Double distanceByPointsInMiles(final Long city1, final Long city2) {
        return cityRepository.distanceByPoints(city1, city2);
    }

    public Double distanceByCubeMeters(final Long city1, final Long city2) {
        final List<City> cities = cityRepository.findAllById(Arrays.asList(city1, city2));
        Point p1 = cities.get(0).getLocation();
        Point p2 = cities.get(1).getLocation();
        return cityRepository.distanceByCube(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }
}
