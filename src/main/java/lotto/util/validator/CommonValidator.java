package lotto.util.validator;

import lotto.util.constant.LottoConstants;

public class CommonValidator {

    private static final char ZERO_ASCII = '0';

    // CONSTANTS FOR EXCEPTION MESSAGE
    private static final String ERR_MSG_EMPTY_INPUT = "[ERROR] 입력값이 존재하지 않습니다.";
    private static final String ERR_MSG_WHITESPACE_INPUT = "[ERROR] 입력값의 앞과 뒤에 공백은 허용되지 않습니다.";

    static void validateEmptyValue(String validateTarget) throws IllegalArgumentException {
        if (validateTarget.isEmpty()) {
            throw new IllegalArgumentException(ERR_MSG_EMPTY_INPUT);
        }
    }

    static void validateWhitespaceAtHeadOrTail(String validateTarget) throws IllegalArgumentException {
        if (!validateTarget.equals(validateTarget.trim())) {
            throw new IllegalArgumentException(ERR_MSG_WHITESPACE_INPUT);
        }
    }

    static void validateEachCharacterIsDigit(String validateTarget, String ERR_MSG) throws IllegalArgumentException {
        char[] targets = validateTarget.toCharArray();
        for (char target : targets) {
            if (!Character.isDigit(target)) {
                throw new IllegalArgumentException(ERR_MSG);
            }
        }
    }

    static void validateStartWithZero(String validateTarget, String ERR_MSG) throws IllegalArgumentException {
        if (validateTarget.charAt(LottoConstants.ZERO) == ZERO_ASCII) { // '0' 문자로 확인
            throw new IllegalArgumentException(ERR_MSG);
        }
    }

}
