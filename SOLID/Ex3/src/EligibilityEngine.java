import java.util.*;

public class EligibilityEngine {
    private final FakeEligibilityStore store;
    private final List<EligibilityRule> rules;

    public EligibilityEngine(FakeEligibilityStore store){

        this.store = store;

        rules = List.of(
                new DisciplinaryRule(),
                new CGRRule(8.0),
                new AttendanceRule(75),
                new CreditsRule(20)
        );
    }
    public void runAndPrint(StudentProfile s) {
        ReportPrinter p = new ReportPrinter();
        EligibilityEngineResult r = evaluate(s); // giant conditional inside
        p.print(s, r);
        store.save(s.rollNo, r.status);
    }

    public EligibilityEngineResult evaluate(StudentProfile s) {
        List<String> reasons = new ArrayList<>();
        String status = "ELIGIBLE";

        for(EligibilityRule rule : rules){

            Optional<String> result = rule.check(s);

            if(result.isPresent()){

                reasons.add(result.get());

                return new EligibilityEngineResult(
                        "NOT_ELIGIBLE",
                        reasons
                );
            }
        }

        return new EligibilityEngineResult(status, reasons);
    }
}

class EligibilityEngineResult {
    public final String status;
    public final List<String> reasons;
    public EligibilityEngineResult(String status, List<String> reasons) {
        this.status = status;
        this.reasons = reasons;
    }
}
