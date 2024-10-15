package si.um.feri.people.vao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRelations {

    @Test
    public void testSorodnosti() {
        Person o1=new Person("Prvi","Novak");
        Person o2=new Person("Drugo","NOVAK");
        Assertions.assertTrue(o1.isInRelationWith(o2));
    }

    @Test
    public void testSorodnosti2() {
        Person o1=new Person("Prvi","Holbl");
        Person o2=new Person("Drugo","Hölbl");
        Assertions.assertTrue(o1.isInRelationWith(o2));
    }
    @Test
    public void testSorodnosti3() {
        Person o1=new Person("Prvi","Pavlic");
        Person o2=new Person("Drugo","PAVLIČ");
        Assertions.assertTrue(o1.isInRelationWith(o2));
    }



}
