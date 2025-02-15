package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator extends Validator {
    static final String INVALID_NUMBER_PARSE = "입력하신 숫자가 유효하지 않습니다, 양수만 입력 가능합니다";
    static final String INVALID_NON_NUMERIC_INPUT = "양수인 숫자만 입력 가능합니다. ex) 1,2,3,4,5,6";
    static final String INVALID_BLANK = "공백은 입력 할 수 없습니다.";
    static final String INVALID_ALREADY_EXISTING_NUMBER = "당첨 번호에 존재하는 번호는 입력 불가";

    private InputValidator() {
        // 인스턴스화 방지를 위해서 사용
    }

    static public void validateInputWinningNumbers(String inputWinningNumber) {
        checkNullOrEmpty(inputWinningNumber);
        checkBlank(inputWinningNumber);
        checkCommaSeparatedNumbers(inputWinningNumber);
    }

    static public void validateInputBonusNumber(String inputBonusNumber) {
        checkNullOrEmpty(inputBonusNumber);
        checkBlank(inputBonusNumber);
        checkNumeric(inputBonusNumber);
    }

    static public void validatePurchaseAmount(String inputPurchaseAmount) {
        checkNullOrEmpty(inputPurchaseAmount);
        checkBlank(inputPurchaseAmount);
        checkNumeric(inputPurchaseAmount);
    }

    static public void findBonusOnWinningNumbers(int bonusNumber, List<Integer> winningNumbers) {
        Set<Integer> _numbers = new HashSet<>(winningNumbers);

        if (_numbers.contains(bonusNumber)) {
            Validator.throwInvalidInputException(INVALID_ALREADY_EXISTING_NUMBER);
        }
    }


    static void checkNullOrEmpty(String input) {
        if (input.isEmpty() || input == null) {
            throwInvalidInputException(INVALID_NON_NUMERIC_INPUT);
        }
    }

    static private void checkBlank(final String inputCarNames) {
        if (inputCarNames.isBlank()) {
            throwInvalidInputException(INVALID_BLANK);
        }
    }

    static void checkCommaSeparatedNumbers(final String numbers) {
        String regex = "^\\d+(,\\d+)*$"; // 숫자 형식이 쉼표로 구분된 형태인지 확인하는 정규식

        if (!numbers.matches(regex)) {
            throwInvalidInputException(INVALID_NON_NUMERIC_INPUT);
        }
    }

    static void checkNumeric(final String input) {
        String regex = "^[0-9]+$";

        if (!input.matches(regex)) {
            throwInvalidInputException(INVALID_NUMBER_PARSE);
        }
    }
}