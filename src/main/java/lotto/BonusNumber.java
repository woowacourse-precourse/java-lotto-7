package lotto;

public class BonusNumber {
    private final LottoNumber bonusNumber;

    public BonusNumber(LottoNumber bonusNumber, WinningNumber winningNumber) {
        validateBonusNumber(bonusNumber, winningNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber.value();
    }

    private void validateBonusNumber(LottoNumber bonusNumber, WinningNumber winningNumber) {
        if(isDuplicateBonusInWinning(bonusNumber, winningNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호에 중복되지 않는 숫자여야 합니다.");
        }
    }

    private Boolean isDuplicateBonusInWinning(LottoNumber bonusNumber, WinningNumber winningNumber){
        return winningNumber.contains(bonusNumber);
    }
}