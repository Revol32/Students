package Data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private String name;
    private List<Subject> timeTable;

    public int getCourseLengthInDays () {
        int lengthHours = 0;
        for (Subject subject : this.timeTable){
            lengthHours += subject.getDuration();
        }
        return (int) Math.ceil(lengthHours / 8);
    }
}
