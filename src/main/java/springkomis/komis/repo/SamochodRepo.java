package springkomis.komis.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import springkomis.komis.klasy.Samochod;

public interface SamochodRepo extends JpaRepository<Samochod, Integer> {
    
}
