package lotto.system.utils.constants;

public enum ProfitMessage implements MessageConstants {

    CONTENT("총 수익률은 %.1f%%입니다.");

    private final String message;

    ProfitMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
