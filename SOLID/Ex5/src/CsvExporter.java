import java.nio.charset.StandardCharsets;
public class CsvExporter extends Exporter {
    @Override
    protected ExportResult encode(String title, String body) {
        String safeTitle = escape(title);
        String safeBody = escape(body);
        String csv = "title,body\n"
                + safeTitle + ","
                + safeBody + "\n";
        return new ExportResult(
                "text/csv",
                csv.getBytes(StandardCharsets.UTF_8)
        );
    }
    private String escape(String s) {
        if (s.contains(",") || s.contains("\n")) {
            return "\"" + s.replace("\"", "\"\"") + "\"";
        }
        return s;
    }
}