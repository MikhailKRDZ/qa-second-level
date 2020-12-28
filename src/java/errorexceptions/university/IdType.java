package java.errorexceptions.university;

import student.IFormIdType;
import student.subject.Subject;

import java.util.ArrayList;
import java.util.List;

public enum IdType implements IFormIdType {
    ID_1("BY1008", GroupType.G_625, FacultyType.ATF, UniversityType.BSPA),
    ID_2("BY1010", GroupType.G_625, FacultyType.ATF, UniversityType.BSPA),
    ID_3("BY1003", GroupType.G_625, FacultyType.ATF, UniversityType.BSPA),
    ID_4("BY1004", GroupType.G_126, FacultyType.MMF, UniversityType.BSPA),
    ID_5("BY1009", GroupType.G_126, FacultyType.MMF, UniversityType.BSPA),
    ID_6("BY1006", GroupType.G_126, FacultyType.MMF, UniversityType.BSPA),
    ID_7("BY1007", GroupType.G_626, FacultyType.ATF, UniversityType.BSPA),
    ID_8("BY1005", GroupType.G_626, FacultyType.ATF, UniversityType.BSPA),
    ID_9("BY1002", GroupType.G_626, FacultyType.ATF, UniversityType.BSPA),
    ID_10("BY1001", GroupType.G_626, FacultyType.ATF, UniversityType.BSPA),

    ;
    private String personId;
    private GroupType groupType;
    private FacultyType facultyType;
    private UniversityType universityType;
    private boolean flagIsIdUsed;
    private final List<Subject> subjectsList = new ArrayList<>();

    IdType(String personId) {
        this.personId = personId;
    }

    IdType(String personId, GroupType groupType, FacultyType facultyType, UniversityType universityType) {
        this.personId = personId;
        this.groupType = groupType;
        this.facultyType = facultyType;
        this.universityType = universityType;
    }

    public void setFlagIsIdUsed(boolean used) {
        this.flagIsIdUsed = used;
    }

    public static IdType getIdTypeByPersonUniqueNumber(String personUniqueNumber) {
        for (IdType idType : IdType.values()) {
            if (idType.getStudentsIdTypeRealName().equals(personUniqueNumber) && !idType.isFlagIdUsed()) {
                return idType;
            }
        }
        return null;
    }

    public String getStudentsIdTypeRealName() {
        return this.personId;
    }

    public GroupType getGroupType() {
        return this.groupType;
    }

    public FacultyType getFacultyType() {
        return this.facultyType;
    }

    public UniversityType getUniversityType() {
        return this.universityType;
    }

    public boolean isFlagIdUsed() {
        return this.flagIsIdUsed;
    }

    public List<Subject> getIdSubjectsList() {
        return this.subjectsList;
    }

    @Override
    public String toString() {
        return name().substring(3);
    }

    @Override
    public void formIdType(String personUniqueNumber, String universityName) {

    }

    @Override
    public void addSubjects(List<Subject> subjectList) {
        this.subjectsList.addAll(subjectList);
    }
}