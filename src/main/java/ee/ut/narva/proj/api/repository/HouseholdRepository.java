package ee.ut.narva.proj.api.repository;

import ee.ut.narva.proj.api.domain.Household;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface HouseholdRepository extends JpaRepository<Household, String>, JpaSpecificationExecutor<Household> {

}
