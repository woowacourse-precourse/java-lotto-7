package lotto.view;

import static lotto.global.constants.Constants.*;

import java.util.List;
import lotto.global.utils.NumberFormatter;

public class InputValidator {

    // 현재 클래스와 관련성이 깊은 상수는 굳이 enum 클래스로 두지 않았다(비즈니스 로직)
    private static final int PURCHASE_MAX_LIMIT = 100_000;
    private static final int PURCHASE_MIN_LIMIT = 1000;
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;

    public void validateStringTypeAmount(String input) {
        validateEmptyInput(input);
        validateNoWhiteSpaceInBetween(input);
        validateContainsOnlyCommaAndDigits(input);
    }

    public void validateIntegerTypeAmount(int amount) {
        validateAmountInRange(amount);
        validateDivisibleByThousand(amount);
    }

    public void validateWinningNumbers(String winningNumbers) {
        validateEmptyInput(winningNumbers);
        String sanitizedNumbers = NumberFormatter.removeAllWhiteSpaces(winningNumbers);
        validateNoWhiteSpaceInBetween(sanitizedNumbers);
        validateContainsOnlyCommaAndDigits(sanitizedNumbers);
    }

    public void validateLottoNumbers(List<Integer> lottoNumbers) {
        validateLottoNumberCount(lottoNumbers);
        validateLottoNumberInRange(lottoNumbers);
    }

    public void validateBonusNumber(String bonusNumber) {
        validateEmptyInput(bonusNumber);
        validateNoWhiteSpaceInBetween(bonusNumber);
        validateContainsOnlyDigit(bonusNumber);

        int parsedBonusNumber = NumberFormatter.parseToInt(bonusNumber);
        validateBonusNumberInRange(parsedBonusNumber);
    }

    // 사용자가 아무 입력도 없이 엔터만 입력했는지 검증
    private void validateEmptyInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_HEADER.getValue() + "입력값이 비어 있습니다. 값을 입력해 주세요.");
        }
    }

    // 입력된 문자열 사이에 공백(스페이스, 탭 등 다양한 공백)이 포함되어 있는지 검증
    private void validateNoWhiteSpaceInBetween(String input) {
        if (input.matches(IS_CONTAIN_WHITESPACE_REGEX.getValue())) {
            throw new IllegalArgumentException(ERROR_HEADER.getValue() + "입력값에 공백이 포함될 수 없습니다.");
        }
    }

    // 입력된 문자에 콤마와 숫자만 담겨 있는지 검증한다.
    private void validateContainsOnlyCommaAndDigits(String input) {
        if (!input.matches(COMMA_DIGITS_REGEX.getValue())) {
            throw new IllegalArgumentException(ERROR_HEADER.getValue() + "입력값은 숫자와 콤마만 포함해야 합니다.");
        }
    }

    // 입력된 문자에 오직 숫자만 담겨 있는지 검증한다.
    private void validateContainsOnlyDigit(String input) {
        if (!input.matches(DIGIT_REGEX.getValue())) {
            throw new IllegalArgumentException(ERROR_HEADER.getValue() + "숫자만 입력해야 합니다.");
        }
    }

    // 콤마를 제거하고 정수형태로 바뀐 사용자의 입력이 1000원 이상 10만원 이하인지 검증한다.
    private void validateAmountInRange(int input) {

        if (input < PURCHASE_MIN_LIMIT) {
            throw new IllegalArgumentException(ERROR_HEADER.getValue() + "1000원 이상부터 구매가 가능합니다.");
        }

        if (input > PURCHASE_MAX_LIMIT) {
            throw new IllegalArgumentException(ERROR_HEADER.getValue() + "10만 원을 초과해서 구매할 수 없습니다.");
        }

    }

    // 입력이 1000으로 나누어 떨어지는지
    private void validateDivisibleByThousand(int input) {
        if (input % PURCHASE_MIN_LIMIT != 0) {
            throw new IllegalArgumentException(ERROR_HEADER.getValue() + "입력값은 1000으로 나누어 떨어져야 합니다.");
        }
    }

    // 사용자가 입력한 로또 개수가 6개가 맞는가?
    private void validateLottoNumberCount(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() < LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_HEADER.getValue() + "입력한 로또 번호의 개수가 부족합니다.");
        } else if (lottoNumbers.size() > LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_HEADER.getValue() + "입력한 로또 번호의 개수가 6개를 초과했습니다.");
        }
    }

    // 사용자가 입력한 로또 번호는 모두 1이상 45이하의 범위 속하는가?
    private void validateLottoNumberInRange(List<Integer> lottoNumbers) {
        for (int number : lottoNumbers) {
            if (number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
                throw new IllegalArgumentException(ERROR_HEADER.getValue() + "범위를 벗어난 번호입니다.");
            }
        }
    }

    private void validateBonusNumberInRange(int bonusNumber) {
        if (bonusNumber < LOTTO_START_NUMBER || bonusNumber > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(ERROR_HEADER.getValue() + "범위를 벗어난 번호입니다.");
        }
    }

}
