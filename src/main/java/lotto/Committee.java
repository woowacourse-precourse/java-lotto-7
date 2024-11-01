package lotto;

public class Committee {

    private final Lotto winningNumbers;
    private final int bonusNumber;

    public Committee(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        validate(winningNumbers, bonusNumber);
    }

    private void validate(Lotto winningNumbers, int bonusNumber) {
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
            Prize prize = Prize.getPrize(matchCount, bonusMatch);
            user.setPrize(prize);
        }
    }
}
