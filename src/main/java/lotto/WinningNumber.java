package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningNumber {
    private final List<Integer> numbers;

    private WinningNumber(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static WinningNumber from(String input) {
        validate(input);
        try {
            List<Integer> numbers = parseNumbers(input);
            return new WinningNumber(numbers);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] " + "문자가 입력됐거나 숫자 범위를 초과하였습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private static void validate(String input) {
        if (input == null) {
            throw new IllegalArgumentException("[ERROR] " + "당첨 번호가 null이어서는 안 됩니다.");
        }
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] " + "당첨 번호가 빈 문자여서는 안 됩니다.");
        }
        if (isEmptyElementContained(input)) {
            throw new IllegalArgumentException("[ERROR] " + "쉼표 사이의 빈 문자가 입력되서는 안 됩니다.");
        }
    }

    private static boolean isEmptyElementContained(String input) {
        return !input.matches("^(\\d+)(,\\d+)*$");
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] " + "당첨 번호는 6개의 숫자여야 합니다.");
        }
        if (isDuplicateExisted(numbers)) {
            throw new IllegalArgumentException("[ERROR] " + "당첨 번호는 중복되지 않아야 합니다.");
        }
        if (isNotInRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] " + "당첨 번호는 1에서 45 사이여야 합니다.");
        }
    }

    private boolean isDuplicateExisted(List<Integer> numbers) {
        Set<Integer> noDuplicateNumbers = new HashSet<>(numbers);
        return noDuplicateNumbers.size() != numbers.size();
    }

    private boolean isNotInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                return true;
            }
        }
        return false;
    }

    private static List<Integer> parseNumbers(String input) {
        return Stream.of(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
