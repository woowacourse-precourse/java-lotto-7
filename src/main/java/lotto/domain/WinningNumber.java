package lotto.domain;

import java.util.List;
import java.util.stream.Stream;

public class WinningNumber {

    private int bonusNumber;
    private List<Integer> winningNumbers;


    public void setWinningNumbers(List<Integer> winningNumbers) {
        validate(winningNumbers);
        duplicateValidate(winningNumbers);
        rangeValidate(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public void setBonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    private void duplicateValidate(List<Integer> winningNumbers) {
        Long size = winningNumbers.stream()
                .distinct()
                .count();
        if (size != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 중복되지 않아야 합니다.");
        }
    }

    private void rangeValidate(List<Integer> winningNumbers) {
        boolean isValid = winningNumbers.stream()
                .allMatch(number -> number >= 1 && number <= 45);
        if (!isValid) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45사이의 숫자여야 합니다.");
        }
    }


    private void validate(int bonusNumber) {
        if (0 > bonusNumber || bonusNumber > 46) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45사이의 숫자여야 합니다.");
        }
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }


}
