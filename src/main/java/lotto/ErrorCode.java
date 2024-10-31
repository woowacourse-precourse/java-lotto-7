package lotto;

public enum ErrorCode {
    INVALID_PURCHASE_AMOUNT("구입 금액은 1,000원 단위로만 가능합니다."),
    CONTIGIOUS_COMMA("입력에 쉼표가 연속적으로 입력되었습니다."),
    INVALID_NUMBER_RANGE("로또 번호의 숫자 범위는 1~45까지입니다."),
    DUPLICATE_WINNIG_NUMBER("입력된 당첨 번호가 중복됩니다."),
    INVALID_WINNIG_NUMBER_COUNT("당첨 번호 개수는 6개이어야 합니다."),
    DUPLICATE_BONNUS_NUMBER("보너스 번호가 당첨 번호와 중복됩니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
