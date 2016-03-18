package ee.ut.narva.proj.api.service;

import ee.ut.narva.proj.api.domain.Household;
import ee.ut.narva.proj.api.domain.Person;
import org.springframework.stereotype.Service;

@Service
public class AllowanceService {

    public Double calculateAllowanceForHousehold(Household household){
        for(Person p : household.getHouseholdMembers()){
            if (p.getAge() < 18){
                return new Double(10);
            }
        }
        return new Double(0);
    }


}
