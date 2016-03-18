package ee.ut.narva.proj.api.domain;

import ee.ut.narva.proj.api.domain.base.UniversallyUniqueIdentity;

import javax.persistence.Entity;

@Entity
public class Allowance extends UniversallyUniqueIdentity {

    private Double baseSum;
    private String name;

}
