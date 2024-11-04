package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class WinningNumberValidator {
    public List<Integer> validate(String winningNumber) {
        isBlank(winningNumber);

        return convert(winningNumber);
    }

    private void isBlank(String input) {
        if (Objects.isNull(input) || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 비어있습니다.");
        }
    }

    private void validateWinningNumberCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개를 입력해야 합니다.");
        }
    }

    private void validateNumberRange(Integer winningNumber) {
        if (winningNumber < 1 || winningNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateUniqueNumber(List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        if (uniqueNumbers.size() < winningNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
    }

    private List<Integer> convert(String input) {
        List<Integer> result = Arrays.stream(input.split(","))
                .map(this::validateNumber)
                .collect(Collectors.toList());

        validateWinningNumberCount(result);
        validateUniqueNumber(result);
        return result;
    }

    private Integer validateNumber(String number) {
        String trimmedNumber = number.trim();
        isBlank(trimmedNumber);
        Integer parsedNumber = parseNumber(trimmedNumber);
        validateNumberRange(parsedNumber);
        return parsedNumber;
    }

    private Integer parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 정수로만 입력이 가능합니다.");
        }
    }
}