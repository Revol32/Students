package Repository;

import Data.Course;
import Data.Student;
import Data.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentsRepository {
    private List<Student> students;

    public StudentsRepository fullRepository () {
        Subject javaServlets = new Subject("javaServlets", 16);
        Subject strutsFramework = new Subject("strutsFramework", 24);
        Subject springFramework = new Subject("springFramework", 48);
        Subject hibernate = new Subject("hibernate", 20);
        Subject javaTechnologyOverview = new Subject("javaTechnologyOverview", 8);
        Subject jFCSwing = new Subject("JFCSwing", 16);
        Subject jDBC = new Subject("JDBC", 16);
        Subject jAX = new Subject("JAX", 52);
        Subject commonsLibraries = new Subject("commonsLibraries", 44);
        Course j2EEDeveloper = new Course("J2EE Developer", List.of(javaServlets,strutsFramework,springFramework,hibernate));
        Course javaDeveloper = new Course("Java Developer", List.of(javaTechnologyOverview, jFCSwing, jDBC, jAX, commonsLibraries));
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student( "Ivanov Ivan", j2EEDeveloper, LocalDate.parse("2021-02-01"), List.of(3, 4, 2, 5, 3, 3)));
        studentList.add(new Student("Petrov Petr", javaDeveloper, LocalDate.parse("2021-02-01"), List.of(4, 5, 3, 2, 3, 3, 5, 5)));
        return new StudentsRepository(studentList);
    }
}
