package lotto.Messages;

public enum ErrorMessage {
    ERROR_PREFIX("[ERROR] "),
    ONLY_NUMBER("구입 금액은 숫자만 기입해주세요."),
    NOT_DIV("구입 금액은 1000으로 나누어 떨어지는 숫자로만 기입해주세요."),
    WIN_INPUT("당첨 번호 조건을 다시 확인하고 입력해 주세요."),
    BONUS("보너스 번호 조건을 다시 확인하고 입력해 주세요."),
    BONUS_RANGE("보너스 정답은 1이상 45이하의 숫자이어야 합니다."),
    BONUS_DUPLICATE("보너스 숫자는 기존 당첨 번호들과 달라야 합니다.");


    private String message;

    private ErrorMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return ERROR_PREFIX.message + message;
    }
}
