package lotto.exception;

import static lotto.constants.CommonConstants.LOTTO_SIZE;
import static lotto.constants.CommonConstants.MAX_LOTTO_NUMBER;
import static lotto.constants.CommonConstants.MAX_PURCHASE_AMOUNT;
import static lotto.constants.CommonConstants.MIN_LOTTO_NUMBER;
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
    DUPLICATE_LOTTO_NUMBER("로또 번호는 중복되지 않아야 합니다."),
    BLANK_WINNING_LOTTO_NUMBERS("공백이 아닌 당첨 번호를 입력해주세요."),
    INVALID_WINNING_LOTTO_NUMBERS_PATTERN("당첨 번호는 쉼표(,)로 구분되는 6개의 숫자들로 입력해야 합니다."),
    OUT_OF_LOTTO_NUMBER_RANGE("로또 번호의 범위는 " + MIN_LOTTO_NUMBER + "부터 " + MAX_LOTTO_NUMBER + "까지 입니다."),
    BLANK_BONUS_NUMBER("공백이 아닌 보너스 번호를 입력해주세요."),
    NON_POSITIVE_BONUS_NUMBER("보너스 번호는 양수이어야 합니다."),
    DUPLICATE_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
