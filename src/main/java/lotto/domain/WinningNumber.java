package lotto.domain;

import lotto.util.ValidatorUtils;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class WinningNumber {
    private final TreeSet<Integer> winningNumbers;
    private int bonusNumber;

    public WinningNumber(String inputWinningNumbers){
        ValidatorUtils.isNotEmpty(inputWinningNumbers);
        winningNumbers = extractWinningNumbers(inputWinningNumbers);
    }

    public int makeBonusNumber(String inputBonusNumber){
        this.bonusNumber = extractBonusNumber(inputBonusNumber);
        return this.bonusNumber;
    }

    private TreeSet<Integer> extractWinningNumbers(String inputWinningNumbers){
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

    private int extractBonusNumber(String inputBonusNumber) {
        ValidatorUtils.isNotEmpty(inputBonusNumber);
        int bonusNumber = ValidatorUtils.canParseToInt(inputBonusNumber);
        ValidatorUtils.isInRange(bonusNumber);
        isWinningNumber(bonusNumber);
        return bonusNumber;
    }

    private void isWinningNumber(int bonusNumber){
        if(this.winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException("당첨 번호에 없는 보너스 번호를 입력하셔야 합니다.");
        }
    }
}
