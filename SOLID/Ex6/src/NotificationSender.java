public abstract class NotificationSender {
    protected final AuditLog audit;
    protected NotificationSender(AuditLog audit) {
        this.audit = audit;
    }
    public final void send(Notification n) {
        if (n == null) {
            throw new IllegalArgumentException("notification cannot be null");
        }
        validate(n);   // common validation hook
        doSend(n);     // actual sending
    }
    protected void validate(Notification n) {
        // default: no strict validation
    }
    protected abstract void doSend(Notification n);
}