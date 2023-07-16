package lesson4.repositories;

import lesson4.models.Teacher;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class TeacherRepository implements UserRepository<Teacher>{

    private final List<Teacher> teachers;

    public TeacherRepository() {
        this.teachers = new ArrayList<>();
    }

    @Override
    public void create(Teacher teacher) {
        teacher.setId(getMaxId() + 1);
        teachers.add(teacher);
    }

    @Override
    public List<Teacher> getAll() {
        return teachers;
    }

    @Override
    public int remove(String fullName) {
        int removeCounter = 0;
        Iterator<Teacher> techerIterator = teachers.iterator();
        while (techerIterator.hasNext()){
            Teacher teacher = techerIterator.next();
            if(teacher.getFullName().equals(fullName)){
                techerIterator.remove();
                removeCounter++;
            }
        }
        return removeCounter;
    }

    @Override
    public List<Teacher> getAllByGroupTitle(String groupTitle) {
        return teachers.stream()
                .filter(teacher -> teacher.getGroupTitle().equals(groupTitle))
                .collect(Collectors.toList());
    }

    private Long getMaxId() {
        Long maxId = 0L;
        for (Teacher teacher : teachers) {
            if (teacher.getId() > maxId) {
                maxId = teacher.getId();
            }
        }
        return maxId;
    }
}
