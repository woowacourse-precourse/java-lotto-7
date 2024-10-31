package lotto;

import java.util.ArrayList;

public class Committee {

    private final ArrayList<Integer> winningNumbers;
    private final int bonusNumber;

    public Committee(ArrayList<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        validate(winningNumbers, bonusNumber);
    }

    private void validate(ArrayList<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }
        if (winningNumbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
        }
        for (int number : winningNumbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("당첨 번호는 1부터 45사이여야 합니다.");
            }
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45사이여야 합니다.");
        }
    }

    public void checkLottos(User user) {
        for (Lotto lotto : user.getLottos()) {
            int matchCount = 0;
            int bonusMatch = 0;
            for (int number : lotto.getNumbers()) {
                if (this.winningNumbers.contains(number)) {
                    matchCount++;
                }
                if (number == this.bonusNumber) {
                    bonusMatch++;
                }
            }
            user.setPrize(matchCount, bonusMatch);
        }
    }
}
