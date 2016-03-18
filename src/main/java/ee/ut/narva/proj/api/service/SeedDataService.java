package ee.ut.narva.proj.api.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import ee.ut.narva.proj.api.domain.*;
import ee.ut.narva.proj.api.repository.*;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.GregorianCalendar;

@Service
public class SeedDataService {

    @Inject
    private AllowanceRepository allowanceRepository;

    @Inject
    private HouseholdRepository householdRepository;

    @Inject
    private PersonRepository personRepository;

    public void populateSeedData() {

        final Person personA = new Person(20, new Double(500));
        final Person personB = new Person(25, new Double(500));
        final Person personC = new Person(30, new Double(500));
        final Person personD = new Person(35, new Double(3000));

        personRepository.save(Lists.newArrayList(personA, personB, personC, personD));

    }
}
