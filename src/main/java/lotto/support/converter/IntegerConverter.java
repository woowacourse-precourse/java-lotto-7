package lotto.support.converter;

import java.util.List;
import lotto.exception.converter.InvalidInputException;

public class IntegerConverter {

    public List<Integer> convertFrom(List<String> numbers) {
        try {
            return numbers.stream()
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException exception) {
            throw new InvalidInputException("Integer 타입의 정수가 아닙니다");
        } catch (NullPointerException exception) {
            throw new InvalidInputException("null일 수 없습니다");
        }
    }

    public int convertFrom(final String input) {
        try {
            validateInput(input);
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException exception) {
            throw new InvalidInputException("Integer 타입의 정수가 아닙니다");
        } catch (NullPointerException exception) {
            throw new InvalidInputException("null일 수 없습니다");
        }
    }

    private void validateInput(final String input) {
        if (input == null) {
            throw new InvalidInputException("입력값은 null일 수 없습니다");
        }
        if (input.isBlank()) {
            throw new InvalidInputException("입력값은 빈 문자열이거나 공백일 수 없습니다");
        }
    }
}
