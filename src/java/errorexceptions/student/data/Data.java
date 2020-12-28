package java.errorexceptions.student.data;

import student.subject.Mark;

import java.util.Arrays;
import java.util.List;

public class Data {
    public List<Mark> subjects1 = Arrays.asList(
            new Mark("Высшая математика", 9),
            new Mark("Геометрия", 8),
//            new Mark("Геометрия", 11),
            new Mark("Философия", 9),
            new Mark("Физкультура", 10)
    );

    public List<Mark> subjects2 = Arrays.asList(
            new Mark("Высшая математика", 9),
            new Mark("Геометрия", 8),
            new Mark("Философия", 10),
            new Mark("Физкультура", 7)
    );
    public List<Mark> subjects3 = Arrays.asList(
            new Mark("Философия", 9),
            new Mark("Физика", 8),
            new Mark("Химия", 10),
            new Mark("Физкультура", 9)
    );
    public List<Mark> subjects4 = Arrays.asList(
            new Mark("Высшая математика", 9),
            new Mark("Геометрия", 8),
            new Mark("Химия", 10),
            new Mark("Физкультура", 7)
    );
    public List<Mark> subjects5 = Arrays.asList(
//            new Mark("Высшая математика", 0),
//            new Mark("Химия", 11),
//            new Mark("Физкультура", 15)

            new Mark("Высшая математика", 10),
            new Mark("Геометрия", 8),
            new Mark("Физкультура", 10)
    );
    public List<Mark> subjects6 = Arrays.asList(
            new Mark("Высшая математика", 10),
            new Mark("Геометрия", 9),
            new Mark("Физкультура", 8)
    );
    public List<Mark> subjects7 = Arrays.asList(
            new Mark("Высшая математика", 10),
            new Mark("Химия", 10),
            new Mark("Физкультура", 10)
    );
    public List<Mark> subjects8 = Arrays.asList(
            new Mark("Высшая математика", 8),
//            new Mark("Высшая математика", 8),
            new Mark("Геометрия", 8),
            new Mark("Физкультура", 8)
    );
    public List<Mark> subjects9 = Arrays.asList(
            new Mark("Высшая математика", 7),
            new Mark("Геометрия", 7),
            new Mark("Химия", 8),
            new Mark("Физкультура", 8)
    );
    public List<Mark> subjects10 = Arrays.asList(
            new Mark("Высшая математика", 7),
            new Mark("Геометрия", 8),
            new Mark("Химия", 9),
            new Mark("Физкультура", 10)
    );
    public List<Person> personList = Arrays.asList(
            new Person("BY1001", "Иванов A.A.", "БГПА", subjects1),
            new Person("BY1002", "Сидоров A.A.", "БГПА", subjects2),

//            new Person("BY1002","Сидоров A.A.", "БГПА", subjects3),

            new Person("BY1003", "Арбузов A.A.", "БГПА", subjects3),
            new Person("BY1004", "Баклажанов A.A.", "БГПА", subjects4),
            new Person("BY1005", "Виноградов A.A.", "БГПА", subjects5),
            new Person("BY1006", "Гарбузов A.A.", "БГПА", subjects6),
            new Person("BY1007", "Деликатесов A.A.", "БГПА", subjects7),
            new Person("BY1008", "Едов A.A.", "БГПА", subjects8),
            new Person("BY1009", "Жаринов A.A.", "БГПА", subjects9),
            new Person("BY1010", "Земляникин A.A.", "БГПА", subjects10)
    );
}
