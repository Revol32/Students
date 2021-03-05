package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class Student {
    String name;
    Course course;
    LocalDate startDate;
    List<Integer> marks;
}
