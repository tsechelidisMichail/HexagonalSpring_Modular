package persistence.databasePrimary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface AccountJpaRepository extends JpaRepository<AccountJpaEntity, Integer> {

	//Custom Queries to be build
}
