import Data.Student;
import Repository.StudentsRepository;
import Service.Services;

import java.time.LocalDate;

public class Main {


    public static void main(String[] args) {
        LocalDate today = LocalDate.parse("2021-02-09");
        StudentsRepository studentsRepository = new StudentsRepository().fullRepository();
        Services services = new Services();
        boolean cycle = true;
        while (cycle) {
            String menu = services.startMessage();
            switch (menu) {
                case "1":
                    for (Student student : services.sortByAVGMark(studentsRepository)) {
                        services.printStudent(student, today);
                    }
                    break;
                case "2":
                    for (Student student : services.sortByDaysToEnd(studentsRepository, today)) {
                        services.printStudent(student, today);
                    }
                    break;
                case "3":
                    for (Student student : services.studentsHaveChance(studentsRepository)){
                        services.printStudent(student, today);
                    }
                    break;
                case "4":
                    cycle = false;
                    break;
            }
        }
    }
}
