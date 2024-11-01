package lotto.constant;

public enum ErrorConstant {

    ERROR("[ERROR]");

    private final String content;

    ErrorConstant(final String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
