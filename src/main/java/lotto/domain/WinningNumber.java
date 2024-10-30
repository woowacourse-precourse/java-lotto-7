package lotto.domain;

import lotto.util.ValidatorUtils;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class WinningNumber {
    private final TreeSet<Integer> winningNumbers;

    public WinningNumber(String inputWinningNumbers){
        ValidatorUtils.isNotEmpty(inputWinningNumbers);
        winningNumbers = extractNumbers(inputWinningNumbers);
    }

    private TreeSet<Integer> extractNumbers(String inputWinningNumbers){
        TreeSet<Integer> numbers = Arrays.asList(inputWinningNumbers.split(",")).stream()
                .map(ValidatorUtils::isNotEmpty)
                .map(ValidatorUtils::canParseToInt)
                .map(ValidatorUtils::isInRange)
                .collect(Collectors.toCollection(TreeSet::new));

        isSixDifferentNumbers(numbers);
        return numbers;
    }

    private void isSixDifferentNumbers(TreeSet<Integer> numbers){
        if(numbers.size() != 6){
            throw new IllegalArgumentException("6개의 서로 다른 수를 입력하셔야 합니다.");
        }
    }
}
