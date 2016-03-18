package ee.ut.narva.proj.api.service;

import com.google.common.collect.Lists;
import ee.ut.narva.proj.api.core.CommonConfig;
import ee.ut.narva.proj.api.domain.Allowance;
import ee.ut.narva.proj.api.domain.Household;
import ee.ut.narva.proj.api.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CommonConfig.class)
public class AllowanceServiceTest {

    @Inject
    AllowanceService allowanceService;

    @Test
    public void shouldReturn0IfNoKids(){
        assertEquals(new Double(0), allowanceService.calculateAllowanceForHousehold(createHouseholdWithNoKids()));
    }

    private Household createHouseholdWithNoKids() {
        Person mother = new Person(40);
        Person father = new Person(40);

        Household household = new Household(Lists.newArrayList(mother, father));

        return household;
    }

}
