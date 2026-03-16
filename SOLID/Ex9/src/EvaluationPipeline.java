public class EvaluationPipeline {
    // DIP violation: high-level module constructs concretes directly
    private final PlagiarismChecker pc;
    private final CodeGrader grader;
    private final ReportWriter writer;
    private final Rubric rubric;
    public EvaluationPipeline(
            PlagiarismChecker pc,
            CodeGrader grader,
            ReportWriter writer,
            Rubric rubric
    ) {
        this.pc = pc;
        this.grader = grader;
        this.writer = writer;
        this.rubric = rubric;
    }

    public void evaluate(Submission sub) {
       
        int plag = pc.check(sub);
        System.out.println("PlagiarismScore=" + plag);

        int code = grader.grade(sub, rubric);
        System.out.println("CodeScore=" + code);

        String reportName = writer.write(sub, plag, code);
        System.out.println("Report written: " + reportName);

        int total = plag + code;
        String result = (total >= 90) ? "PASS" : "FAIL";
        System.out.println("FINAL: " + result + " (total=" + total + ")");
    }
}
