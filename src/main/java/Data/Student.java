package Data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    private Course course;
    private LocalDate startDate;
    private List<Integer> marks;

    public int getCountOfMarks() {
        return marks.size();
    }

    public double getAVGMark(LocalDate date) {
        int days = (int) DAYS.between(startDate, date);
        return (double) marks.stream().mapToInt(n -> n).sum() / days;
    }

    public double getAVGMarkToSort() {
        return (double) marks.stream().mapToInt(n -> n).sum() / marks.size();
    }

    public int hoursRemain(LocalDate date) {
        int daysGone = (int) DAYS.between(this.getStartDate(), date) - 1;
        int lengthHours = 0;
        for (Subject subject : this.getCourse().getTimeTable()) {
            lengthHours += subject.getDuration();
        }
        return lengthHours - daysGone * 8;
    }
}
