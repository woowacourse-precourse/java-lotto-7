package lotto.Constants;

import jdk.dynalink.NamedOperation;

public enum Error {
    PURCHASE_AMOUNT_LT_MINIMUM("로또 구입 금액은 1000원 이상이어야 합니다."),
    PURCHASE_AMOUNT_NOT_MULTIPLE_OF_1000("로또 구입 금액은 1000원 단위로 입력해야 합니다."),
    PARSE_INT_ERROR("숫자로 변환할 수 없는 값입니다."),
    NO_SUCH_ELEMENT_EXCEPTION("입력이 잘못되었습니다.");

    private final String text;

    Error(String text) {
        this.text = text;
    }

    public String getText() {
        return "[Error] " + text;
    }
}
