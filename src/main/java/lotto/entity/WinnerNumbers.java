package lotto.entity;

import java.util.List;

public class WinnerNumbers {
    private final Lotto mainNumbers;
    private final int bonusNumber;

    public WinnerNumbers(List<Integer> mainNumbers, int bonusNumber) {
        this.mainNumbers = new Lotto(mainNumbers);
        this.bonusNumber = bonusNumber;
        validate(mainNumbers, bonusNumber);
    }

    private void validate(List<Integer> mainNumbers, int bonusNumber) {
        if (!(1 <= bonusNumber && bonusNumber <= 45)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45까지의 숫자여야 합니다.");
        }
        if (mainNumbers.stream().anyMatch(number -> number == bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
