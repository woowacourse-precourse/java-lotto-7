package lotto.validator;

import lotto.error.ErrorMessage;

public class NumbersInputValidator implements Validator<String> {
    @Override
    public void validate(String input) {
        validateIsIntegerList(input);
        validateDelimiter(input);
    }

    private void validateDelimiter(String input) {
        // 입력 문자열이 쉼표로 구분되지 않은 경우 예외 발생
        if (!input.contains(",")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DELIMITER.getMessage());
        }
    }

    private void validateIsIntegerList(String input) {
        // 입력 문자열이 정수로 구성된 목록이 아닌 경우 예외 발생
        String[] numbers = input.split(",");
        for (String number : numbers) {
            if (!number.trim().matches("-?\\d+")) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_INTEGER.getMessage());
            }
        }
    }
}
