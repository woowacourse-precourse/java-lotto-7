package lotto;


public class LottoBonusNumber {
    private final Integer bonusNumber;

    public LottoBonusNumber(Integer bonusNumber, Lotto winningLotto) {
        validate(bonusNumber, winningLotto);
        this.bonusNumber = bonusNumber;
    }
    private void validate(Integer bonusNumber, Lotto winningLotto) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
        }

        for(int i = 0; i < 6; i++){
            if (winningLotto.get(i) == bonusNumber)
                throw new IllegalArgumentException("[ERROR] 보너스 볼은 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
