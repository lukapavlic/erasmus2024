package si.um.feri.people.vao;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.text.Normalizer;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.regex.Pattern;

@Data
@NoArgsConstructor
@Entity
public class Person {

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    private String name;

    private String surname;

    @Id
    @GeneratedValue
    private int id;

    private LocalDate birthDate =LocalDate.now();

    public long getAge() {
        long ret=ChronoUnit.YEARS.between(birthDate, LocalDate.now());
        if (ret<0) ret=0;
        return ret;
    }

    public boolean isInRelationWith(Person person2) {
        if (person2 == null || this.getSurname() == null || person2.getSurname() == null) {
            return false;
        }
        String priimek1 = normalize(this.getSurname());
        String priimek2 = normalize(person2.getSurname());
        return priimek1.equalsIgnoreCase(priimek2);
    }

    private String normalize(String input) {
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalized).replaceAll("").replace("Đ", "D").replace("đ", "d");
    }

}
