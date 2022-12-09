package web_account.adapter.out.persistense;

import org.springframework.data.jpa.repository.JpaRepository;

interface AccountJpaRepository extends JpaRepository<AccountJpaEntity, Integer> {

	//Custom Queries to be build
}
