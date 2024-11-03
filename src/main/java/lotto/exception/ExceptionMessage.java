package lotto.exception;

import static lotto.constants.CommonConstants.LOTTO_SIZE;
import static lotto.constants.CommonConstants.MAX_PURCHASE_AMOUNT;
import static lotto.constants.CommonConstants.UNIT_PURCHASE_AMOUNT;
import static lotto.view.InputView.MAX_ATTEMPTS;

public enum ExceptionMessage {
    BLANK_PURCHASE_AMOUNT("공백이 아닌 구입 금액을 입력해주세요."),
    NON_POSITIVE_PURCHASE_AMOUNT("구입 금액은 양수이어야 합니다."),
    NOT_DIVIDED_BY_UNIT_AMOUNT("구입 금액은 단위 금액인 " + UNIT_PURCHASE_AMOUNT + "으로 나누어 떨어져야 합니다."),
    EXCEEDS_MAX_PURCHASE_AMOUNT("구입 금액은 최대 구매가능 금액인 " + MAX_PURCHASE_AMOUNT + "을 넘지 못합니다."),
    EXCEEDS_MAX_ATTEMPTS("최대 입력 횟수인 " + MAX_ATTEMPTS + "회를 초과했습니다. 프로그램을 종료합니다."),
    NULL_LOTTO("로또는 null값일 수 없습니다."),
    INVALID_LOTTO_SIZE("로또 번호는 " + LOTTO_SIZE + "개여야 합니다."),
    INVALID_LOTTO_ORDER("로또 번호는 오름차순으로 정렬되어야 합니다."),
    DUPLICATE_LOTTO_NUMBER("로또 번호는 중복되지 않아야 합니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
