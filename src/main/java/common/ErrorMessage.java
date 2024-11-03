package common;

public enum ErrorMessage {
    INVALID_TYPE("정상적인 입력타입이 아닙니다"),
    INVALID_PRICE("계산 가능한 가격이 아닙니다"),
    INVALUD_LOTTO_NUMBER("당첨 번호의 입력이 정상적이지 않습니다"),
    INVALUD_LOTTO_BONUS_NUMBER("보너스 번호가 정상적이지 않습니다"),
    INVALUD_LOTTO_SCOPE("1 ~ 45 사이의 숫자만 입력할 수 있습니다"),
    INVALUD_LOTTO_CONTAINS("당첨 번호가 중복되어 있습니다"),
    NONE_INPUT("값이 입력되지 않았습니다");

    private String message;

    ErrorMessage(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
