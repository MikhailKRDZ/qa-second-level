package errorexceptions.university;

import errorexceptions.universitycustomsexception.FacultyHasInsufficientGroupsException;
import errorexceptions.universitycustomsexception.GroupsWithoutStudentsException;
import errorexceptions.universitycustomsexception.NoSubjectsForTheStudent;
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
                throw new IllegalArgumentException("group with this name exist, group " + group.getName());
            }
        }
        this.groupList.add(group);
    }

    public Group getGroup(String groupName) throws FacultyHasInsufficientGroupsException, IllegalArgumentException {
        if (this.groupList.isEmpty()) {
            throw new FacultyHasInsufficientGroupsException(" No Groups in Faculty " + this.realFacultyName);
        }
        for (Group group : getGroupList()) {
            if (group.getName().equals(groupName)) {
                return group;
            }
        }
        throw  new IllegalArgumentException("No group in Faculty " + this.realFacultyName + "  with this Name" + groupName);
    }

    @Override
    public ArrayList<Subject> getSubjectList() throws NoSubjectsForTheStudent, GroupsWithoutStudentsException {
        ArrayList<Subject> subjectArrayList = new ArrayList<>();
        for (Group group : this.groupList) {
                subjectArrayList.addAll(group.getSubjectList());
        }
        return subjectArrayList;
    }

    public double getAverage() throws NoSubjectsForTheStudent, GroupsWithoutStudentsException {
        int sum = 0;
        for (Subject subject : getSubjectList()) {
                sum = sum + subject.getMark();
            }
        return (double) sum / getSubjectList().size();
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
        int subjectNumber = 0;
                for (Subject subject : getSubjectList()) {
                    if (subject.getName().equals(subjectType.getSubjectRealName())) {
                        sum = sum + subject.getMark();
                        subjectNumber = subjectNumber + 1;
                    }
                }
        return (double) sum / subjectNumber;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "realFacultyName='" + realFacultyName + '\'' +
                ", groupList=" + groupList +
                '}';
    }
}