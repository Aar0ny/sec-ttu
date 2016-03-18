package ee.ut.narva.proj.api.domain;

import ee.ut.narva.proj.api.domain.base.UniversallyUniqueIdentity;

import javax.persistence.Entity;

@Entity
public class Person extends UniversallyUniqueIdentity {

    private int age;
    private Double income = new Double(0);

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Person(int age, Double income) {
        this.age = age;
        this.income = income;
    }

    public Person(int age) {
        this.age = age;
    }
}
