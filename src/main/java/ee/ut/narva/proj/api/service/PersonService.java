package ee.ut.narva.proj.api.service;

import ee.ut.narva.proj.api.domain.Household;
import ee.ut.narva.proj.api.domain.Person;
import ee.ut.narva.proj.api.repository.PersonRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class PersonService {


    @Inject
    private PersonRepository personRepository;

    public List<Person> findAll(){
        return personRepository.findAll();
    }


}
