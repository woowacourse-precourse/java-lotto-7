package domain.error;

public enum InputErrorMessage {
    ONLY_NUMBERS_ALLOWED("입력값은 숫자만 허용됩니다. 21억보다 적은 숫자를 입력해주세요."),
    PURCHASE_LOTTO_CONDITION("로또 구매 금액은 1000원 단위 입니다."),
    WINNING_NUMBER_VALIDATION("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_NUMBER_NOT_IN_WINNING_NUMBERS("보너스 번호가 선택한 당첨 번호와 중복됩니다.")
    ;
    private final String inputErrorMessage;
    private final String PREFIX = "[ERROR] ";

    private InputErrorMessage(String inputErrorMessage) {
        this.inputErrorMessage = PREFIX + inputErrorMessage;
    }

    public String getErrorMessage() {
        return inputErrorMessage;
    }
}
