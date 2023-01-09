package springkomis.komis.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import springkomis.komis.klasy.ImgUrl;

public interface ImgUrlRepo extends JpaRepository<ImgUrl, Integer> {
    
}
