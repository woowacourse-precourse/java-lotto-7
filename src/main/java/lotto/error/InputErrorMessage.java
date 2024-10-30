package lotto.error;

public enum InputErrorMessage implements ErrorMessage {
    NON_BLANK("입력은 공백일 수 없습니다.");

    private final String message;

    InputErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
