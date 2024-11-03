package lotto.validator;

import lotto.util.Constants;

public class InputValidatorImpl implements InputValidator {

    public void validateCostForm(int price) {
        if (price % Constants.PURCHASE_FORM != 0)
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야합니다.");
    }

    public int validateNumber(String string) {
        try {
            int number = Integer.parseInt(string);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력받은 문자열을 숫자로 변환할 수 없습니다.");
        }
    }

    public void validateNumberRange(int number) {
        if (number <= 0 || number > Constants.MAX_NUM) {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 0원 이하이거나 최대한도를 넘을 수 없습니다.");
        }
    }

    public void validateEmpty(String string) {
        if (string == null || string.isEmpty())
            throw new IllegalArgumentException("[ERROR] 입력받은 문자열이 빈문자열 또는 null입니다.");
    }

    public void validateNumbersForm(String string) {
        if (!string.matches(Constants.VALID_INPUT_PATTERN)) {
            throw new IllegalArgumentException("[ERROR] 입력받은 당첨번호의 문자열 형식이 불일치합니다.");
        }
    }
}
