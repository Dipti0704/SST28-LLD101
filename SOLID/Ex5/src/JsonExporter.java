import java.nio.charset.StandardCharsets;
public class JsonExporter extends Exporter {
    @Override
    protected ExportResult encode(String title, String body) {
        String json =
                "{\"title\":\""
                        + escape(title)
                        + "\",\"body\":\""
                        + escape(body)
                        + "\"}";
        return new ExportResult(
                "application/json",
                json.getBytes(StandardCharsets.UTF_8)
        );
    }
    private String escape(String s) {
        return s.replace("\"", "\\\"");
    }
}