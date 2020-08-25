import java.util.Objects;

public abstract class Task {
    private final String name;
    private boolean Done = false;
    private static final String MESSAGE_BLANK_TASK = "Did you casually forget to put in the description of the task?";

    public Task(String name) throws BlankTaskException {
        if (name.isBlank()) {
            throw new BlankTaskException(MESSAGE_BLANK_TASK);
        }
        this.name = name.strip();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return (isDone() ? "[✓] " : "[✗] ") + name;
    }

    public boolean isDone() {
        return Done;
    }

    public void markAsDone() {
        Done = true;
    }

    public abstract String[] attributeList();

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Task task = (Task) o;
        return Done == task.Done &&
                Objects.equals(name, task.name);
    }

    @Override public int hashCode() {
        return Objects.hash(name, Done);
    }
}
