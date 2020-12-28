package javatasks.errorexceptions.student.data;


import javatasks.errorexceptions.student.Student;
import javatasks.errorexceptions.student.subject.Mark;

import java.util.List;

public class Person extends Student {
    private final int counterPerson;
    private String personUniqueNumber;
    private String personName;
    private static int counterPersonStatic;

    {
        counterPersonStatic++;
    }

    public Person(String personUniqueNumber, String personName, String universityName, List<Mark> markList) {
        super(personUniqueNumber, personName, universityName, markList);
        this.counterPerson = counterPersonStatic;
        setPersonUniqueNumber(personUniqueNumber);
        setPersonName(personName);
    }

    void setPersonUniqueNumber(String personUniqueNumber) {
        if (personUniqueNumber != null) {
            this.personUniqueNumber = personUniqueNumber;
        }
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonUniqueName() {
        return super.getPersonUniqueName();
    }

    public int getCounterPerson() {
        return this.counterPerson;
    }

    public String getUniquePersonName() {
        return personUniqueNumber;
    }

    public String getPersonName() {
        return this.personName;
    }

    public String getUniversityName() {
        return super.getUniversityType().getRealUniversityName();
    }

    @Override
    public String toString() {
        return "id: " + getIdType() + ",\t" + "counterPerson: " + getCounterPerson() + ",\t " + "personUniqueNumber: " +
                getUniquePersonName() + ",\t " + "personName: " + getPersonName() + ",\t " +
                "university: " + getUniversityName() + ",\t " + "faculty: " +
                getFacultyType() + ",\t " + "group: " + getGroupType() + ",\t " + getSubjectList() + "\t\n";
    }
}