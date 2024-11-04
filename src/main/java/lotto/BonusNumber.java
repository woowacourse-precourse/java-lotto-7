package lotto;

public class BonusNumber {
    private final LottoNumber bonusNumber;

    public BonusNumber(LottoNumber bonusNumber, WinningNumber winningNumber) {
        if(winningNumber.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호에 중복되지 않는 숫자여야 합니다.");
        }
        this.bonusNumber = bonusNumber;
    }
}