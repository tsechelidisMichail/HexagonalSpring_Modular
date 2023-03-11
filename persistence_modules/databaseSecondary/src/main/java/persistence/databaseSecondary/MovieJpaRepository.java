package persistence.databaseSecondary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface MovieJpaRepository extends JpaRepository<MovieJpaEntity, Integer> {
    //@Query("SELECT m FROM Movie m WHERE m.name = ?1")
    MovieJpaEntity findMovieByName(String name);
}
