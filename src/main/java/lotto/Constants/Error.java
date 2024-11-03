package lotto.Constants;

/**
 * 사용자에게 출력할 에러 메시지를 정의한 enum
 */
public enum Error {
    PURCHASE_AMOUNT_LT_MINIMUM("로또 구입 금액은 1000원 이상이어야 합니다."),
    PURCHASE_AMOUNT_NOT_MULTIPLE_OF_1000("로또 구입 금액은 1000원 단위로 입력해야 합니다."),
    PARSE_INT_ERROR("숫자로 변환할 수 없는 값입니다."),
    NO_SUCH_ELEMENT_EXCEPTION("입력이 잘못되었습니다."),
    LOTTO_NUMBERS_SIZE_NOT_6("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBERS_DUPLICATED("로또 번호는 중복되면 안됩니다."),
    LOTTO_NUMBERS_OUT_OF_RANGE("로또 번호는 1부터 45 사이여야 합니다."),
    LACK_OF_FUNDS("금액이 부족합니다."),
    TOO_MANY_ERRORS("너무 많은 잘못된 입력입니다. 프로그램을 종료합니다."),;

    private final String text;

    Error(String text) {
        this.text = text;
    }

    public String getText() {
        return "[ERROR] " + text;
    }
}
