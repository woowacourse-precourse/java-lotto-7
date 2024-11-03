package lotto.util.validator;
import lotto.util.constant.LottoConstants;

import java.util.List;

import static lotto.util.constant.LottoConstants.*;

public class BonusNumbersValidator extends CommonValidator {

    private static final String ERR_MSG_NO_DIGIT_BONUS_NUMBER = "[ERROR] 보너스 번호의 입력은 숫자만 가능합니다.";
    private static final String ERR_MSG_NOT_IN_THRESHOLD_BONUS_NUMBER = "[ERROR] 보너스 번호는 1-45 사이의 숫자만 가능합니다.";
    private static final String ERR_MSG_DUPLICATE_WINNER_NUMBER = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    private static final String ERR_MSG_START_WITH_ZERO = "[ERROR] 보너스 번호는 0으로 시작할 수 없습니다.";

    /**
     * 사용자에게 입력받은 로또 구입 금액이 유효한 입력값인지 검사
     * 검사 과정
     * - 1. 먼저 입력받은 값이 비어있는지 확인한다.
     * - 2. 앞 뒤에 공백이 존재하는지 확인한다.
     * - 3. 입력된 모든 값이 Digit인지 확인한다.
     * - 4. 맨 앞에 0으로 설정되어있는지 확인한다.
     * - 5. Integer.paresInt로 정수로 바꾼다.
     * - 6. 1-45 사이의 숫자인지 확인한다.
     * - 7. 로또 보너스 번호와 중복되지는 않는지 확인한다.
     */
    public static void validateBonusNumber(String inputBonusNumber, List<Integer> winnerNumbers){
        validateEmptyValue(inputBonusNumber);
        validateWhitespaceAtHeadOrTail(inputBonusNumber);
        validateEachCharacterIsDigit(inputBonusNumber, ERR_MSG_NO_DIGIT_BONUS_NUMBER);
        validateStartWithZero(inputBonusNumber, ERR_MSG_START_WITH_ZERO);
        validateItIsBetweenThreshold(inputBonusNumber);
        validateItHasDuplicateNumber(inputBonusNumber, winnerNumbers);
    }

    private static void validateItIsBetweenThreshold(String target){
        int targetNumber = Integer.parseInt(target);
        if (targetNumber < LOTTO_MIN_NUMBER || targetNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(ERR_MSG_NOT_IN_THRESHOLD_BONUS_NUMBER);
        }
    }

    private static void validateItHasDuplicateNumber(String target, List<Integer> winnerNumbers) {
        int targetNumber = Integer.parseInt(target);
        if (winnerNumbers.contains(targetNumber)) {
            throw new IllegalArgumentException(ERR_MSG_DUPLICATE_WINNER_NUMBER);
        }
    }
}
