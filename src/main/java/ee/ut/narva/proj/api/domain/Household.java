package ee.ut.narva.proj.api.domain;

import ee.ut.narva.proj.api.domain.base.UniversallyUniqueIdentity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Household extends UniversallyUniqueIdentity {

    public Household(List<Person> householdMembers) {
        this.householdMembers = householdMembers;
    }

    @OneToMany
    private List<Person> householdMembers;

    @OneToMany
    private List<Allowance> allowances;

    public List<Person> getHouseholdMembers() {
        return householdMembers;
    }

    public void setHouseholdMembers(List<Person> householdMembers) {
        this.householdMembers = householdMembers;
    }

    public List<Allowance> getAllowances() {
        return allowances;
    }

    public void setAllowances(List<Allowance> allowances) {
        this.allowances = allowances;
    }
}
