package si.um.feri.people.vao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class Person2Test {

    List<Person> people = new ArrayList<>();

    @BeforeEach
    void initialize() {
        people = new ArrayList<>();
        people.add(new Person("Peter","Klepec"));
        people.add(new Person("Martin","Krpan"));
    }

    @Test
    void test2() {
        Assertions.assertEquals(2, people.size());
    }

    @Test
    void test3() {
        people.add(new Person("Mojca","Pokrajculja"));
        Assertions.assertEquals(3, people.size());
    }

    @Test
    void test4() {
        people.remove(new Person("Peter","Klepec"));
        Assertions.assertEquals(1, people.size());
    }

}
