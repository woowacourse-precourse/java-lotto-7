package lotto.domain;

import lotto.util.ValidatorUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {
    private final Lotto winningNumbers;
    private int bonusNumber;

    public WinningNumber(String inputWinningNumbers) {
        ValidatorUtils.isNotEmpty(inputWinningNumbers);
        winningNumbers = new Lotto(extractWinningNumbers(inputWinningNumbers));
    }

    public int makeBonusNumber(String inputBonusNumber) {
        this.bonusNumber = extractBonusNumber(inputBonusNumber);
        return this.bonusNumber;
    }

    public int calculateCorrectCount(Lotto lotto) {
        int correctCount = 0;
        for (int number : lotto.getNumbers()) {
            if (this.winningNumbers.contains(number)) {
                correctCount++;
            }
        }
        return correctCount;
    }

    public boolean correctBonus(Lotto lotto) {
        if (lotto.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    private List<Integer> extractWinningNumbers(String inputWinningNumbers) {
        return Arrays.asList(inputWinningNumbers.split(",")).stream()
                .map(ValidatorUtils::isNotEmpty)
                .map(ValidatorUtils::canParseToInt)
                .map(ValidatorUtils::isInRange)
                .collect(Collectors.toList());
    }

    private int extractBonusNumber(String inputBonusNumber) {
        ValidatorUtils.isNotEmpty(inputBonusNumber);
        int bonusNumber = ValidatorUtils.canParseToInt(inputBonusNumber);
        ValidatorUtils.isInRange(bonusNumber);
        isWinningNumber(bonusNumber);
        return bonusNumber;
    }

    private void isWinningNumber(int bonusNumber) {
        if (this.winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호에 없는 보너스 번호를 입력하셔야 합니다.");
        }
    }
}
