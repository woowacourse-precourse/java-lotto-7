package lotto;

public enum LogType {
    ERROR("[ERROR]");

    public final String prefix;

    LogType(String prefix) {
        this.prefix = prefix;
    }
}
