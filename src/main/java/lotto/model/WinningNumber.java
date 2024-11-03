package lotto.model;

public class WinningNumber {
    private final Lotto winningNumber;
    private final BonusNumber bonusNumber;

    public WinningNumber(Lotto winningNumber, BonusNumber bonusNumber) {
        validateDuplication(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }

    private void validateDuplication(Lotto winningNumber, BonusNumber bonusNumber){
        if(winningNumber.getNumbers().contains(bonusNumber.getBonusNumber())){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복 될 수 없습니다.");
        }
    }

}
