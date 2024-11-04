package lotto;

public enum ErrorMessage {
    INVALID_INPUT("[ERROR] 잘못된 입력입니다."),
    INVALID_PRICE("[ERROR] 1000원 단위의 금액을 입력해주세요."),
    INVALID_NUMBERS("[ERROR] 쉼표로 구분된 6개의 번호(1~45)를 입력해주세요."),
    INVALID_BOUNUS("[ERROR] 1~45의 보너스 번호를 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
