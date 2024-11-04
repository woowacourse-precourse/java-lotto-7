package lotto.contants.message;

public enum ErrorMessage {
    PURCHASE_PRICE("구입 금액 단위는 1,000원입니다."),
    SPILT_EMPTY("쉼표(,) 사이에 숫자가 존재해야합니다."),
    TYPE("숫자만 입력해주세요."),
    LOTTO_NUMBER_RANGE("로또 번호 범위는 1~45입니다."),
    LOTTO_SIZE("로또 번호는 6개여야 합니다."),
    LOTTO_BONUS("보너스 번호는 당첨 번호와 일치할 수 없습니다."),
    LOTTO_DUPLICATION("같은 숫자가 있을 수 없습니다."),
    LOTTO_RANK("로또 등수는 1~5입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
