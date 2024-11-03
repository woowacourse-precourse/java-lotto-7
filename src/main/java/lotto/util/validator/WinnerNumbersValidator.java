package lotto.util.validator;

public class WinnerNumbersValidator extends CommonValidator {

    private static final String ERR_MSG_NOT_DIGIT_WINNER_NUMBERS = "[ERROR] 로또 당첨 번호는 ,를 제외하고 숫자로만 구성되어야 합니다.";
    private static final String ERR_MSG_START_WITH_ZERO_WHEN_SPLIT_BY_COMMA = "[ERROR] 각각의 숫자는 0으로 시작할 수 없습니다.";
    private static final String NAME_DELIMITER = ",";

    /**
     * 컨트롤러에서 사용자에게 입력받은 당첨 로또 번호가 유효한지 검사
     * 1. 값이 비어있는지 검사
     * 2. 문자열에서 ,를 없애는 경우 경우 숫자만 존재하는지 검사
     * 3. 문자열을 ,로 분리했을 경우 null 즉 "1,,2"와 같이 비어있는 값이 존재하는지 검사
     * 4. 문자열을 ,로 분리했을 경우 각각의 숫자가 0으로 시작하는지 검증
     */

    public static void validateWinnerNumber(String inputWinnerNumber) throws IllegalArgumentException {
        validateEmptyValue(inputWinnerNumber);
        validateWhitespaceAtHeadOrTail(inputWinnerNumber);
        validateEachCharacterIsDigit(inputWinnerNumber.replaceAll(",",""),ERR_MSG_NOT_DIGIT_WINNER_NUMBERS);
        validateEachNumberIsEmpty(inputWinnerNumber);
        validateEachNumberStartWithZero(inputWinnerNumber);
    }

    private static void validateEachNumberStartWithZero(String validateTarget){
        for (String eachTarget : validateTarget.split(NAME_DELIMITER)) {
            validateStartWithZero(eachTarget, ERR_MSG_START_WITH_ZERO_WHEN_SPLIT_BY_COMMA);
        }
    }

    private static void validateEachNumberIsEmpty(String validateTarget){
        for (String eachTarget : validateTarget.split(NAME_DELIMITER)) {
            validateEmptyValue(eachTarget);
        }
    }
}
