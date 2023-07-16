package lesson4.view;

import lesson4.controllers.TeacherController;
import lesson4.controllers.UserController;
import lesson4.models.Student;
import lesson4.models.Teacher;

import java.util.List;

public class TeacherView implements UserView{

    private UserController<Teacher> controller;

    public TeacherView(UserController<Teacher> controller) {
        this.controller = controller;
    }

    @Override
    public void sendOnConsole() {
        sendOnConsole(SortType.NONE);
    }

    @Override
    public void sendOnConsole(SortType sortType) {

        List<Teacher> teachers = switch (sortType) {
            case NONE -> controller.getAll();
            case NAME -> controller.getAllSortByFullName();
            case ID -> controller.getAllSortById();
        };

        if (teachers == null || teachers.size() == 0) {
            System.out.println("Отсутствуют учителя для вывода");
            return;
        }

        System.out.println("===================================");
        System.out.println("Для вывода использована " + sortType);
//        for (Student student : students) {
//            System.out.println(student);
//        }
//        students.forEach((student) -> System.out.println(student));
        teachers.forEach(System.out::println);
        System.out.println("===================================");
    }

    @Override
    public void create(String fullName, Integer age, String phoneNumber, String groupTitle) {
        controller.create(fullName, age, phoneNumber, groupTitle);
    }

    @Override
    public void removeUser(String fullName) {
        int removeCount = controller.remove(fullName);

        if (removeCount == 0) {
            System.out.println("Удаление не получилось.");
        } else {
            System.out.println("Удалено Учителей: " + removeCount);
        }
    }
}
