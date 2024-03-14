
import java.time.Instant;

public class Annotation {
    private String text;
    private Instant lastModified;

    public Annotation(String text) {
        this.text = text;
        this.lastModified = Instant.now();
    }

    public Annotation(String text, Instant lastModified) {
        this.text = text;
        this.lastModified = lastModified;
    }

    public String getText() {
        return text;
    }

    public Instant getLastModified() {
        return lastModified;
    }

    public void setText(String text) {
        this.text = text;
        this.lastModified = Instant.now();
    }

    // Вычисление времени с последнего изменения аннотации в секундах
    public long getTimeLastModified() {
        Instant now = Instant.now();
        return now.getEpochSecond() - lastModified.getEpochSecond();
    }

    @Override
    public String toString() {
        return "Annotation{" +
                "text='" + text + '\'' +
                ", lastModified=" + lastModified +
                '}';
    }
}
