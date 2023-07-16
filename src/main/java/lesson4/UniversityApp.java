package lesson4;

import lesson4.controllers.GroupController;
import lesson4.controllers.StudentController;
import lesson4.controllers.TeacherController;
import lesson4.models.Student;
import lesson4.models.Teacher;
import lesson4.repositories.StudentRepository;
import lesson4.repositories.TeacherRepository;
import lesson4.services.GroupService;
import lesson4.services.StudentService;
import lesson4.services.TeacherService;
import lesson4.view.GroupView;
import lesson4.view.SortType;
import lesson4.view.StudentView;
import lesson4.view.TeacherView;

import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.Long.parseLong;

public class UniversityApp {
    private StudentRepository studentRepository;
    private StudentService studentService;
    private StudentController studentController;

    private TeacherRepository teacherRepository;
    private TeacherService teacherService;
    private TeacherController teacherController;

    private TeacherView teacherView;
    private StudentView studentView;
    private GroupView groupView;


    public void run(){
        createAllViews();
        showInterface();
        String input = getInput();
        while (!input.equalsIgnoreCase("exit")){
            String[] inputArray = input.split("-");
            switch (inputArray[0]){
//                case inputArray[0].equals("/get") -> getInfo(inputArray[1]);
//                case inputArray[0].equals("/create") -> createUser(inputArray[1]);
//                case inputArray[0].equals("/delete") -> deleteUser(inputArray[1]);
//                case inputArray[0].equals("/set") -> setGroup(inputArray);
                case "/get" -> getInfo(inputArray[1]);
                case "/create" -> createUser(inputArray[1]);
                case "/delete" -> deleteUser(inputArray[1]);
                case "/set" -> setGroup(inputArray);
                default ->
                    System.out.println("--- INVALID INPUT, TRY AGAIN ---");
            }
            showInterface();
            input = getInput();
        }
    }
// /set, group, (Student/Teacher), by,id (id) (Group)
    private void setGroup(String[] inputArray) {
        if (inputArray.length != 5) {
            System.out.println("--- INVALID INPUT, INFO-LENGTH 01 ---");
            return;
        }
        String[] sArray = inputArray[4].split(" ");
        if (sArray.length != 3) {
            System.out.println("--- INVALID INPUT, INFO-LENGTH 02 ---");
            return;
        }
        if (inputArray[2].equalsIgnoreCase("Student")) {
            boolean flag = true;
            for (Student student : studentController.getAll()) {
                if (student.getId().equals(parseLong(sArray[1]))) {
                    student.setGroupTitle(sArray[2]);
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("--- INVALID INPUT, INFO-LENGTH 03 ---");
                return;
            } else {
                System.out.println("Group changed");
            }
            } else if (inputArray[2].equalsIgnoreCase("Teacher")) {
                boolean flag = true;
                for (Teacher teacher : teacherController.getAll()) {
                    if (teacher.getId().equals(parseLong(sArray[1]))) {
                        teacher.setGroupTitle(sArray[2]);
                        flag = false;
                    }
                }
                if (flag) {
                    System.out.println("--- INVALID INPUT, INFO-LENGTH 03 ---");
                    return;
                } else {
                    System.out.println("Group changed");
                }
            } else {
                System.out.println("--- INVALID INPUT, (Student/Teacher) ---");
            }
        }

    // (Student/Teacher) (Name_FamilyName/ id)
    private void deleteUser(String s) {
        String[] sArray = s.split(" ");
        if(sArray.length != 2){
            System.out.println("--- INVALID INPUT, INFO-LENGTH ---");
            return;
        }
        if(sArray[0].equalsIgnoreCase("Student")){
            studentView.removeUser(sArray[1].replace('_',' '));
            System.out.println("Student Deleted");
        } else if (sArray[0].equalsIgnoreCase("Teacher")) {
            teacherView.removeUser(sArray[1].replace('_',' '));
            System.out.println("Student Teacher");
        } else {
            System.out.println("--- INVALID INPUT, (Student/Teacher) ---");
        }

    }

    //(Student/Teacher) (Name_FamilyName) (Age) (phoneNumber) (Group)
    private void createUser(String s) {
        String[] sArray = s.split(" ");
        if(sArray.length != 5){
            System.out.println("--- INVALID INPUT, INFO-LENGTH ---");
            return;
        }
        if(sArray[0].equalsIgnoreCase("Student")){
            studentView.create(sArray[1].replace('_',' '), Integer.valueOf(sArray[2]),sArray[3],sArray[4]);
            System.out.println("Student created");
        } else if (sArray[0].equalsIgnoreCase("Teacher")) {
            teacherView.create(sArray[1].replace('_',' '), Integer.valueOf(sArray[2]),sArray[3],sArray[4]);
            System.out.println("Teacher created");
        } else {
            System.out.println("--- INVALID INPUT, (Student/Teacher) ---");
        }
    }

    private void showInterface() {
        System.out.println("Options: ");
        System.out.println("1. /get-(Student/Teacher) (name/id/nothing)");
        System.out.println("2. /get-group (group)");
        System.out.println("3. /create-(Student/Teacher) (Name_FamilyName) (phoneNumber) (Age) (Group)");
        System.out.println("4. /delete-(Student/Teacher) (Name_FamilyName)");
        System.out.println("5. /set-group-(Student/Teacher)-by-(id) (Group)");
        System.out.println("6. EXIT");

    }
    // Options:
    // 1. group (group)
    // 2. (Student/Teacher) (name/id/nothing)
    private void getInfo(String s) {
        if(s == null){
            System.out.println("--- INVALID INPUT, TRY AGAIN ---");
            return;
        }
        String[] sArray = s.split(" ");
        if(sArray[0].equals("group") ){
            if(sArray.length > 1){
                groupView.printAllFromGroup(sArray[1]);
            } else {
                groupView.printAllFromGroup();
            }
        } else if(sArray[0].equalsIgnoreCase("Student")){
            if(sArray.length > 1){
                studentView.sendOnConsole(SortType.valueOf(sArray[1].toUpperCase()));
            } else {
                studentView.sendOnConsole();
            }
        }  else if(sArray[0].equalsIgnoreCase("Teacher")){
            if(sArray.length > 1){
                teacherView.sendOnConsole(SortType.valueOf(sArray[1].toUpperCase()));
            } else {
                teacherView.sendOnConsole();
            }
        }
    }

    private String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    private void createAllViews() {
        setStudentView();
        setTeacherView();
        setGroupView();

        studentView.create("Ivan Morozov", 18, "02", "11Б");
        studentView.create("Ivan Morozov", 18, "02", "11Б");
        studentView.create("Petr Vorobev", 19, "03", "10А");
        studentView.create("Sidor Sidorov", 20, "112", "10А");
        studentView.create("Elena Ivanova", 19, "911", "10А");
        studentView.create("Anna Morozova", 17, "01", "11А");

        teacherView.create("Alexander Kovalchuk", 56, "054", "11Б");
        teacherView.create("Stanislav Utkin", 38, "055", "10А");
        teacherView.create("Stas Molniv", 41, "056", "11А");
    }

    private void setStudentView() {
        studentRepository = new StudentRepository();
        studentService = new StudentService(studentRepository);
        studentController = new StudentController(studentService);
        this.studentView = new StudentView(studentController);
    }

    private void setTeacherView() {
        teacherRepository = new TeacherRepository();
        teacherService = new TeacherService(teacherRepository);
        teacherController = new TeacherController(teacherService);
        this.teacherView = new TeacherView(teacherController);
    }

    private void setGroupView() {
        GroupService groupService = new GroupService(studentService, teacherService);
        GroupController groupController = new GroupController(groupService);
        this.groupView = new GroupView(groupController);
    }
}
