package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class InputValidator {
    private static final String DELIMITER = ",";
    private static final String NUMBER_RANGE_PATTERN = "^(?:[1-9]|[1-3][0-9]|4[0-5])$";
    private static final String VALID_NUMBERS_PATTERN = "^[0-9]+(,[0-9]+)*$";
    /*
    TODO 입력값을 검증한다
    1. String input을 int로 변환 시도(숫자가 아니면 안됨)
    2. int 중 1000 단위로 나눠떨어지는 지 확인(금액은 1000원 단위로 입력해야 함)

    * */
    public void validateInputAmount(String input) {
        // null 이나 0을 입력하면?
        validateNullAndEmptyValue(input);
        // 숫자만 입력받기
        validateOnlyNumber(input);
        // 1000 단위로 나눠떨어지나? 체크
        validateIsDivisibleByThousand(input);
    }

    public void validateInputNumbers(String input) {
        //구분자로 나누기
        validateDelimitedNumbersFormat(input);
        String[] numbers = input.split(DELIMITER);
        validateEnterSixNumbers(numbers);
        Set<String> uniqueNumbers = new HashSet<>();
        for (String number : numbers) {
            validateNumberInRange(number);
            validateDuplicateNumber(number, uniqueNumbers);
        }

    }

    private void validateDelimitedNumbersFormat(String input) {
        if (!input.matches(VALID_NUMBERS_PATTERN)) {
            throw new IllegalArgumentException();
        }
    }

    public void validateInputBonusNumber(List<Integer> winnerNumbers, String input) {
        validateNumberInRange(input);
        validateBonusNumberNotInWinnerNumbers(winnerNumbers, input);
    }

    private void validateEnterSixNumbers(String[] numbers) {
        if (numbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해야 합니다.");
        }
    }

    private void validateNumberInRange(String number) {
        if (!number.matches(NUMBER_RANGE_PATTERN)) {
            throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 숫자를 입력해야 합니다.");
        }
    }

    private void validateDuplicateNumber(String number, Set<String> uniqueNumbers) {
        if (!uniqueNumbers.add(number)) {
            throw new IllegalArgumentException("[ERROR] 중복된 NUMBER가 존재하면 안됩니다.");
        }
    }

    private void validateOnlyNumber(String input) {
        if (!input.matches("^[1-9][0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        }
    }

    private void validateNullAndEmptyValue(String input) {
        if (input == null || input.isEmpty() || input.equals("0")) {
            throw new IllegalArgumentException("[ERROR] 빈 값 혹은 0은 입력할 수 없습니다.");
        }
    }

    private void validateIsDivisibleByThousand(String input) {
        int number = Integer.parseInt(input);
        if (number <= 0 || number % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000으로 나눠지는 값만 입력할 수 있습니다.");
        }
    }

    private void validateBonusNumberNotInWinnerNumbers(List<Integer> winnerNumbers, String input) {
        int bonusNumber = Integer.parseInt(input);
        if (winnerNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
