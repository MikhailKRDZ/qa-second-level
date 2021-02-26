package errorexceptions.data;

public enum SubjectType {

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
        for (SubjectType subjectType : SubjectType.values()) {
            if (subjectType.subjectsRealName.equals(code)) {
                return subjectType;
            }
        }
        return null;
    }

    public String getSubjectRealName() {
        return subjectsRealName;
    }
}
