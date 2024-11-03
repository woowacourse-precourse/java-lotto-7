package lotto.model.strategy;

import java.util.List;
import lotto.model.lotto.Lotto;

public class CustomStrategy implements LottoStrategy{

    private static final String INVALID_EMPTY_MESSAGE = "[ERROR] 로또 번호가 빈 값입니다.";
    private static final String INVALID_NUMERIC_MESSAGE = "[ERROR] 로또 번호는 숫자만 입력 가능합니다.";
    private static final String INPUT_DELIMITER_REGEX = ",";

    private final List<String> input;

    private CustomStrategy(List<String> input) {
        validateNumeric(input);
        this.input = input;
    }

    public static CustomStrategy of(String input) {
        validateInputEmpty(input);
        return new CustomStrategy(splitInputByDelimiter(input));
    }

    private static void validateInputEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(INVALID_EMPTY_MESSAGE);
        }
    }

    private void validateNumeric(List<String> splitInput) {
        try {
            splitInput.forEach(Integer::parseInt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMERIC_MESSAGE);
        }
    }

    private static List<String> splitInputByDelimiter(String input) {
        return List.of(input.split(INPUT_DELIMITER_REGEX, -1));
    }

    @Override
    public Lotto generateLotto() {
        List<Integer> numbers = input.stream()
                .map(number ->
                        Integer.parseInt(number.strip())
                ).toList();
        return new Lotto(numbers);
    }
}
