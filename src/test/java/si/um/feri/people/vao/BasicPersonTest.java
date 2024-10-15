package si.um.feri.people.vao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.time.LocalDate;
import java.util.stream.Stream;

public class BasicPersonTest {

    static Stream<Object[]> personProvider() {
        return Stream.of(
                new Object[] { LocalDate.now().minusYears(22), 22 },
                new Object[] { LocalDate.now().minusYears(24).plusDays(1), 23 },
                new Object[] { LocalDate.now().minusYears(24).minusDays(1), 24 },
                new Object[] { LocalDate.now().plusYears(55), 0 },
                new Object[] { LocalDate.of(2000,2,29), 24 }
        );
    }

    @ParameterizedTest
    @MethodSource("personProvider")
    public void testDatumovVLetu2024(LocalDate datum, long expectedStarost) {
        Person o=new Person("Michael","Jackson", datum);
        Assertions.assertEquals(expectedStarost, o.getAge());
    }

}
