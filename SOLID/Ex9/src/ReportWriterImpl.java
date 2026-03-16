public class ReportWriterImpl implements ReportWriter {
    public String write(Submission s, int plag, int code) {
        return "report-" + s.roll + ".txt";
    }
}