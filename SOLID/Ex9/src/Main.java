public class Main {
    public static void main(String[] args) {
        System.out.println("=== Evaluation Pipeline ===");
        Submission sub = new Submission("23BCS1007", "public class A{}", "A.java");
                EvaluationPipeline pipeline =
                new EvaluationPipeline(new PlagiarismCheckerImpl(),new CodeGraderImpl(),new ReportWriterImpl(), new Rubric() );
        pipeline.evaluate(sub);

    }
}
