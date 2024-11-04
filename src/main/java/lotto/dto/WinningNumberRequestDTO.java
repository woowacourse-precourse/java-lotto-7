package lotto.dto;

import java.util.Arrays;
import java.util.List;

public class WinningNumberRequestDTO {
    private static final String NOT_NUMBER_MESSAGE = "[ERROR] 당첨 번호를 숫자를 입력해야 합니다.";

    private final List<Integer> numbers;

    public WinningNumberRequestDTO(String input) {
        List<Integer> numbers = parseNumbers(input);
        this.numbers = numbers;

    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private List<Integer> parseNumbers(String input) {
        List<String> stringNumbers = Arrays.stream(input.split(",")).toList();
        return stringNumbers.stream()
                .map(this::parseNumber)
                .toList();
    }

    private Integer parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
        }
    }
}
