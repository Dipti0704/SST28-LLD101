import java.util.*;

public class CreditsRule implements EligibilityRule {
    private final int minCredits;
    public CreditsRule(int minCredits){
        this.minCredits = minCredits;
    }
    public Optional<String> check(StudentProfile s){
        if(s.earnedCredits < minCredits)
            return Optional.of("credits below " + minCredits);
        return Optional.empty();
    }
}