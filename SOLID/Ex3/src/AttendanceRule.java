import java.util.*;

public class AttendanceRule implements EligibilityRule {
    private final int minAttendance;
    public AttendanceRule(int minAttendance){
        this.minAttendance = minAttendance;
    }
    public Optional<String> check(StudentProfile s){
        if(s.attendancePct < minAttendance)
            return Optional.of("attendance below " + minAttendance);
        return Optional.empty();
    }
}