package si.um.feri.people;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import si.um.feri.people.dao.PersonRepository;
import si.um.feri.people.rest.PersonController;
import si.um.feri.people.vao.Person;

@SpringBootTest
class PeopleApplicationTests {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	PersonController controller;
    @Autowired
    private PersonController personController;

	@BeforeEach
	void init() {
		personRepository.deleteAll();
	}

	@Test
	void contextLoads() {
		Person person = new Person("John","Deere");
		personRepository.save(person);
		Assertions.assertEquals(1, personRepository.count());
	}

	@Test
	void restTest() {
		Assertions.assertEquals(0, personRepository.count());
		personController.postPerson(new Person("Ime","Priimek"));
		Assertions.assertEquals(1, personRepository.count());
	}

}
