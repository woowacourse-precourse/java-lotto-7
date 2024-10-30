package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private final List<Integer> winningNumbers;

    public WinningNumbers(String input) {
        this.winningNumbers = parseAndValidate(input);
    }

    private List<Integer> parseAndValidate(String input) {
        try {
            List<Integer> numbers = Arrays.stream(input.split(","))
                    .map(s -> Integer.parseInt(s.trim()))
                    .collect(Collectors.toList());
            if (numbers.size() != 6 || new HashSet<>(numbers).size() != 6) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복 없이 6개여야 합니다.");
            }
            if (numbers.stream().anyMatch(num -> num < MIN || num > MAX)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이여야 합니다.");
            }
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해야 합니다.");
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
