package errorexceptions.university;

import errorexceptions.customsexception.FacultyHasInsufficientGroupsException;
import errorexceptions.customsexception.GroupsWithoutStudentsException;
import errorexceptions.customsexception.NoSubjectsForTheStudent;
import errorexceptions.data.SubjectType;

import java.util.ArrayList;
import java.util.List;

public class Faculty implements IUniversity {
    private final String realFacultyName;
    private final ArrayList<Group> groupList;

    public Faculty() {
        this(null);
    }

    public Faculty(String realFacultyName) {
        this.realFacultyName = realFacultyName;
        this.groupList = new ArrayList<>();
    }

    public void addGroup(Group group) throws IllegalArgumentException {
        for (Group addedGroup : this.groupList) {
            if (addedGroup.getName().equals(group.getName())) {
                throw new IllegalArgumentException("wrong group" + group.getName());
            }
        }
        this.groupList.add(group);
    }

    public Group getGroup(String groupName) throws FacultyHasInsufficientGroupsException, IllegalArgumentException {
        if (this.groupList.isEmpty()) {
            throw new FacultyHasInsufficientGroupsException(" No Groups in Faculty " + this.realFacultyName);
        }
        for (Group group : this.groupList) {
            if (group.getName().equals(groupName)) {
                return group;
            }
        }
        throw  new IllegalArgumentException("No group in Faculty " + this.realFacultyName + "  with this Name" + groupName);
    }

    @Override
    public ArrayList<Subject> getSubjectList() throws NoSubjectsForTheStudent, GroupsWithoutStudentsException {
        ArrayList<Subject> subjectArrayList ;
        subjectArrayList = new ArrayList<>();
        for (Group group : this.groupList) {
            for (Student student : group.getStudentList()) {
                subjectArrayList.addAll(student.getSubjectList());
            }
        }
        return subjectArrayList;
    }

    public double getAverage() throws NoSubjectsForTheStudent, GroupsWithoutStudentsException {
        int sum = 0;
        int number = 0;
        for (Subject subject : getSubjectList()) {
                sum = sum + subject.getMark();
                number = number + 1;
            }
        return (double) sum / number;
    }

    public String getName() {
        return this.realFacultyName;
    }

    public List<Group> getGroupList() {
        return this.groupList;
    }

    @Override
    public double getAverage(SubjectType subjectType) throws NoSubjectsForTheStudent, GroupsWithoutStudentsException {
        int sum = 0;
        int number = 0;
                for (Subject subject : getSubjectList()) {
                    if (subject.getName().equals(subjectType.getSubjectRealName())) {
                        sum = sum + subject.getMark();
                        number = number + 1;
                    }
                }
        return (double) sum / number;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "realFacultyName='" + realFacultyName + '\'' +
                ", groupList=" + groupList +
                '}';
    }
}