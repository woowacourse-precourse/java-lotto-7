package lotto.model;

import java.util.HashSet;

public class WinningNumbers {
    private final Lotto mainNumbers;
    private final int bonusNumber;

    public WinningNumbers(Lotto mainNumbers, String bonusNumberString) {
        int bonusNumber = parseToInt(bonusNumberString);
        validate(mainNumbers, bonusNumber);
        this.mainNumbers = mainNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int countMatchingNumbers(Lotto lotto) {
        HashSet<Integer> lottoNumbers = new HashSet<>(lotto.getNumbers());
        HashSet<Integer> winningNumbers = new HashSet<>(mainNumbers.getNumbers());

        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean containsNumber(Lotto lotto) {
        return lotto.containsNumber(bonusNumber);
    }

    private int parseToInt(String number) {
        try {
            return Integer.parseInt(number);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야합니다.");
        }
    }

    private void validate(Lotto mainNumbers, int bonusNumber) {
        validateBonusNumberDuplicate(mainNumbers, bonusNumber);
        validateBonusNumberRange(bonusNumber);
    }

    private void validateBonusNumberDuplicate(Lotto mainNumbers, int bonusNumber) {
        if (mainNumbers.containsNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }
}
