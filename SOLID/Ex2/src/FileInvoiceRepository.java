public class FileInvoiceRepository implements InvoiceRepository {
    private final FileStore store = new FileStore();
    public void save(String id, String content){
        store.save(id, content);
    }
    public int countLines(String id){
        return store.countLines(id);
    }
}