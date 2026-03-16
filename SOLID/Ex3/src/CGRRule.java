import java.util.*;

public class CGRRule implements EligibilityRule {
    private final double minCgr;
    public CGRRule(double minCgr){
        this.minCgr = minCgr;
    }
    public Optional<String> check(StudentProfile s){
        if(s.cgr < minCgr)
            return Optional.of("CGR below " + minCgr);
        return Optional.empty();
    }
}