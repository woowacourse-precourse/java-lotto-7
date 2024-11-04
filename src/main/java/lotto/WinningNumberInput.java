package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumberInput {

    private static final int WINNING_NUMBER_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static List<Integer> requestWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요. (쉼표로 구분된 6개의 숫자)");
        String input = Console.readLine();
        return parseAndValidateWinningNumbers(input);
    }

    public static List<Integer> parseAndValidateWinningNumbers(String input) {
        List<Integer> winningNumbers;

        try {
            winningNumbers = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
        }

        validateWinningNumbers(winningNumbers);
        return winningNumbers;
    }

    private static void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않아야 합니다.");
        }

        boolean allInRange = numbers.stream().allMatch(num -> num >= MIN_NUMBER && num <= MAX_NUMBER);
        if (!allInRange) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이여야 합니다.");
        }
    }
}