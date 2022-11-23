package springkomis.komis.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springkomis.komis.klasy.Samochod;

public interface SamochodRepo extends JpaRepository<Samochod, Integer> {
    List<Samochod> findByCenaBetween(Double x, Double y);
}
