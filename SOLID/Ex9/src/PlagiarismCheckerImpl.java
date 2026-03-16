public class PlagiarismCheckerImpl implements PlagiarismChecker {
    public int check(Submission s) {
        return (s.code.contains("class") ? 12 : 40);
    }
}