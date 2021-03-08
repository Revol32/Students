package Service;

import Data.Student;
import Repository.StudentsRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;

import static java.time.temporal.ChronoUnit.DAYS;

public class Services {

    public boolean isStudentHaveChance (Student student) {
        int courseLength = student.getCourse().getCourseLengthInDays();
        double possibleMark = (double) (student.getMarks().stream().mapToInt(n->n).sum() + 5*(courseLength-student.getCountOfMarks()))/courseLength;
        return possibleMark >= 4.5;
    }

    public LinkedList<Student> sortByAVGMark (StudentsRepository studentsRepository) {
        LinkedList<Student> result = new LinkedList<>(studentsRepository.getStudents());
        result.sort(Comparator.comparingDouble(Student::getAVGMarkToSort));
        return result;
    }

    public LinkedList<Student> sortByDaysToEnd (StudentsRepository studentsRepository , LocalDate date) {
        LinkedList<Student> result = new LinkedList<>(studentsRepository.getStudents());
        Comparator<Student> comparator = Comparator.comparingLong(o -> DAYS.between(o.getStartDate(), date));
        result.sort(comparator);
        return result;
    }

    public LinkedList<Student> studentsHaveChance (StudentsRepository studentsRepository) {
        LinkedList<Student> result = new LinkedList<>();
        for (Student student : studentsRepository.getStudents()){
            if (isStudentHaveChance(student)){
                result.add(student);
            }
        }
        if (result.isEmpty()) {
            System.out.println("Нет студентов для вывода");
        }
        return result;
    }

    public String startMessage() {
        List <String> menusList = Arrays.asList("1","2","3","4");
        System.out.println("Успеваемость студаентов");
        System.out.println("Выбирите действие:");
        System.out.println("1. Отсортировать студентов по среднему балу.");
        System.out.println("2. Отсортировать студентов по времени до окончания обучения.");
        System.out.println("3. Вывести студентов у которых есть вероятность, что не будет отчислен");
        System.out.println("4. Выход.");
        System.out.println("Выберете пункт меню:");
        String menu = new Scanner(System.in).nextLine();
        if (!menusList.contains(menu)){
            System.out.println("Ввидите верное значение от 1 до 4");
            startMessage();
        }
        return menu;
    }

    public void printStudent(Student student, LocalDate date) {
        Services services = new Services();
        String chance = !services.isStudentHaveChance(student) ? "Отчислить" : "Может продолжать обучение";
        System.out.println(student.getName() + " - До окончания обучения по программе " + student.getCourse().getName() + " "+student.hoursRemain(date)+" ч. Средний балл " +
                BigDecimal.valueOf(student.getAVGMark(date)).setScale(2, RoundingMode.HALF_UP) + ". " + chance + ".");
    }
}
