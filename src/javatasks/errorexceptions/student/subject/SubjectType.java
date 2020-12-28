package javatasks.errorexceptions.student.subject;

public enum SubjectType  {

    ADVANCED_MATHEMATICS("Высшая математика"),
    GEOMETRY("Геометрия"),
    PHILOSOPHY("Философия"),
    PHYSICS("Физика"),
    CHEMISTRY("Химия"),
    PHYSICAL_CULTURE("Физкультура"),
    ;
    private String subjectsRealName;

    SubjectType() {
    }

    SubjectType(String subject) {
        this.subjectsRealName = subject;
    }


    public static SubjectType getSubjectValueByRealName(String code) {
        for (SubjectType subjectsRealName : SubjectType.values()) {
            if (subjectsRealName.subjectsRealName.equals(code)) {
                return subjectsRealName;
            }
        }
        return null;
    }

    public String getSubjectRealName() {
        return subjectsRealName;
    }

}
