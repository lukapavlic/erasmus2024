package si.um.feri.people.rest;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import si.um.feri.people.dao.PersonRepository;
import si.um.feri.people.vao.Person;
import java.util.Optional;
import java.util.logging.Logger;

@CrossOrigin
@RestController
public class PersonController {

    Logger logger = Logger.getLogger(PersonController.class.getName());

    @Autowired
    PersonRepository repository;

    @GetMapping("/info")
    public String info(){
        return "Hello World!";
    }

    @GetMapping("/people")
    public Iterable<Person> getAllPeople(){
        logger.info("Getting all Person data");
        return repository.findAll();
    }

    @GetMapping("/people/{id}")
    public Optional<Person> getPersonById(@PathParam("id") int id){
        logger.info("Get Person by id: " + id);
        return repository.findById(id);
    }

    @PutMapping("/people")
    public void putPerson(Person person){
        logger.info("Put Person with id: " + person.getId());
        repository.save(person);
    }

    @PostMapping("/people")
    public Person postPerson(Person person){
        logger.info("Post Person " + person);
        Person newPerson = new Person(person.getName(), person.getSurname());
        repository.save(newPerson);
        return newPerson;
    }

}
