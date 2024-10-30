package lotto.enums;

public enum Exceptions {
    NOT_BLANK("빈 칸은 입력할 수 없습니다.");

    private final String message;

    Exceptions(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
