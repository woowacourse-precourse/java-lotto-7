package lotto.model.domain;

public class LottoWinningNumbers {
    private final Lotto winningLottoNumbers;
    private final BonusNumber bonusNumber;

    public LottoWinningNumbers(Lotto winningLottoNumbers, BonusNumber bonusNumber) {
        this.winningLottoNumbers = winningLottoNumbers;
        bonusNumberDuplicateValidator(winningLottoNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void bonusNumberDuplicateValidator(Lotto winningLottoNumbers, BonusNumber bonusNumber) {
        if (winningLottoNumbers.getNumbers().contains(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다.");
        }
    }

    public boolean isContainsWinningNumbers(int number) {
        return winningLottoNumbers.getNumbers().contains(number);
    }

    public boolean isContainsBonusNumber(int number) {
        return bonusNumber.getBonusNumber() == number;
    }

    public Lotto getWinningLottoNumbers() {
        return winningLottoNumbers;
    }

    public BonusNumber getWinningBonusNumber() {
        return bonusNumber;
    }
}