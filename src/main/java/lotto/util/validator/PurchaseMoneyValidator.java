package lotto.util.validator;

import lotto.util.constant.LottoConstants;

public class PurchaseMoneyValidator {
    private static final char ZERO_ASCII = '0';
    private static final int ZERO = 0;

    // CONSTANTS FOR EXCEPTION MESSAGE
    private static final String ERR_MSG_WRONG_PURCHASE_INPUT ="[ERROR] 로또 구입 금액은 1,000원 단위의 양의 정수이여야합니다.";
    private static final String ERR_MSG_WRONG_WINNER_NUMBERS = "[ERROR] 로또 당첨 번호는 1부터 45 사이의 6개의 숫자여야 합니다.";
    private static final String ERR_MSG_WRONG_BONUS_NUMBER = "[ERROR] 로또 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";

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
        validateEachCharacterIsDigit(inputPurchaseMoney);
        validateStartWithZero(inputPurchaseMoney);
        validateDivisibleByBaseUnit(inputPurchaseMoney);
    }

    static void validateEmptyValue(String validateTarget) throws IllegalArgumentException {
        if (validateTarget.isEmpty()) {
            throw new IllegalArgumentException(ERR_MSG_WRONG_PURCHASE_INPUT);
        }
    }

    static void validateWhitespaceAtHeadOrTail(String validateTarget) throws IllegalArgumentException {
        if (!validateTarget.equals(validateTarget.trim())) {
            throw new IllegalArgumentException(ERR_MSG_WRONG_PURCHASE_INPUT);
        }
    }

    static void validateEachCharacterIsDigit(String validateTarget) throws IllegalArgumentException {
        char[] targets = validateTarget.toCharArray();
        for (char target : targets) {
            if (!Character.isDigit(target)) {
                throw new IllegalArgumentException(ERR_MSG_WRONG_PURCHASE_INPUT);
            }
        }
    }

    static void validateStartWithZero(String validateTarget) throws IllegalArgumentException {
        if (validateTarget.charAt(ZERO) == ZERO_ASCII) { // '0' 문자로 확인
            throw new IllegalArgumentException(ERR_MSG_WRONG_PURCHASE_INPUT);
        }
    }

    static void validateDivisibleByBaseUnit(String validateTarget) throws IllegalArgumentException {
        long target = Long.parseLong(validateTarget);
        if (target % LottoConstants.LOTTO_BASE_UNIT != ZERO) {
            throw new IllegalArgumentException(ERR_MSG_WRONG_PURCHASE_INPUT);
        }
    }

}
