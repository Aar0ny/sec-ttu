package ee.ut.narva.proj.api.repository;

import ee.ut.narva.proj.api.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface AllowanceRepository extends JpaRepository<Allowance, String>, JpaSpecificationExecutor<Allowance> {

}
