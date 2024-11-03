package lotto.util.validator;

import lotto.util.constant.LottoConstants;

public class PurchaseMoneyValidator extends CommonValidator {

    private static final String ERR_MSG_NOT_DEVISIBLE_BY_BASE_UNIT ="[ERROR] 로또는 1,000원 단위로만 구입이 가능합니다.";
    private static final String ERR_MSG_NOT_DIGIT_INPUT ="[ERROR] 로또 구입 금액은 숫자로만 구성되어야합니다.";
    private static final String ERR_MSG_START_WITH_ZERO_INPUT ="[ERROR] 로또 구입 금액은 0으로 시작할 수 없습니다..";

    /**
     * 사용자에게 입력받은 로또 구입 금액이 유효한 입력값인지 검사
     * 검사 과정
     * - 1. 먼저 입력받은 값이 비어있는 값인지 확인한다.
     * - 2. 앞 뒤에 공백을 제거한다. -> trim()
     * - 3. 입력 받은 값의 모든 값이 숫자인지 확인한다.
     *      - 가운데에 공백이 끼어있는지 검증 가능.
     *      - 맨 앞에 -로 시작하는 음수인지 검증 가능.
     * - 4. 맨 앞이 0으로 설정되어있는지 확인한다.
     * - 5. Long.parseLong()를 이용해서 정수로 바꾼다.
     * - 6. 1000원으로 딱 나뉘어 떨어지는지 확인한다.
     *
     * @param inputPurchaseMoney
     */
    public static void validatePurchaseMoney(String inputPurchaseMoney) throws IllegalArgumentException {
        validateEmptyValue(inputPurchaseMoney);
        validateWhitespaceAtHeadOrTail(inputPurchaseMoney);
        validateEachCharacterIsDigit(inputPurchaseMoney, ERR_MSG_NOT_DIGIT_INPUT);
        validateStartWithZero(inputPurchaseMoney, ERR_MSG_START_WITH_ZERO_INPUT);
        validateDivisibleByBaseUnit(inputPurchaseMoney);
    }

    static void validateDivisibleByBaseUnit(String validateTarget) throws IllegalArgumentException {
        long target = Long.parseLong(validateTarget);
        if (target % LottoConstants.LOTTO_BASE_UNIT != LottoConstants.ZERO) {
            throw new IllegalArgumentException(ERR_MSG_NOT_DEVISIBLE_BY_BASE_UNIT);
        }
    }

}
