package architecture.analyzer.main;

public record CodeViolation(String fileName, int lineNumber, String message) {

    @Override
    public String toString() {
        return String.format("%s:%d - %s", fileName, lineNumber, message);
    }
}
