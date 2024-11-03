package lotto.model;

public class WinningLotto {
    private final Lotto winningNumber;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;

        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Ranking calculateRank(Lotto userLotto) {
        return Ranking.calculateRanking(winningNumber.makeMatchInfo(userLotto, bonusNumber));
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 수만 가능합니다.");
        }

        winningNumber.checkBonusNumberDuple(bonusNumber);
    }
}
