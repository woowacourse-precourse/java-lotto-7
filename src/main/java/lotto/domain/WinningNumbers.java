package lotto.domain;

public class WinningNumbers {

    private final Lotto mainNumbers;
    private  BonusNumber bonusNumber;


    public WinningNumbers(Lotto winnerLotto, BonusNumber bonusNumber) {
        validate(winnerLotto, bonusNumber);
        this.mainNumbers = winnerLotto;
        this.bonusNumber = bonusNumber;
    }


    private void validate(Lotto mainNumbers, BonusNumber bonusNumber) {
        validateBonusNumberDuplicate(mainNumbers, bonusNumber);
    }

    private void validateBonusNumberDuplicate(Lotto mainNumbers, BonusNumber bonusNumber) {
        if (mainNumbers.contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }




}
