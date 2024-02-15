package practise_2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class ApplToHuman {
    public void create() {
        Human h1 = new Human(12, "Вася", "Иванов", LocalDate.of(2012, 12, 4), 100);
        Human h2 = new Human(77, "Baba", "Babushka", LocalDate.of(1940, 9, 27), 78);
        Human h3 = new Human(27, "Иван", "Васильев", LocalDate.of(1997, 3, 15), 80);
        Human h4 = new Human(54, "Галина", "Петрова", LocalDate.of(1968, 1, 1), 54);
        Human h5 = new Human(19, "Анастасия", "Шведова", LocalDate.of(2004, 2, 17), 49);
        List<Human> input = new ArrayList<>();
        input.add(h1);
        input.add(h2);
        input.add(h3);
        input.add(h4);
        input.add(h5);
        Stream<Human> stream = input.stream();
        stream.forEach( human -> {human.weight = human.weight - 5;});
        stream = input.stream();
        StringBuilder str = new StringBuilder();
        stream.filter(human -> human.birthDate.isBefore(LocalDate.of(1999, 2, 3)))
        .forEach(human -> str.append(human.lastName).append(" "));
        System.out.println(str.toString());
    }
}
