package lotto;

public enum MessageCenter {
    ERROR_MESSAGE("[ERROR] ");

    private final String msg;

    private MessageCenter(String msg) {
        this.msg = msg;
    }

    public String get() {
        return this.msg;
    }
}
