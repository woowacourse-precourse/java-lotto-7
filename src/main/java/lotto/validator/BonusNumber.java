package lotto.validator;

public class BonusNumber implements InputTypeValidator{
    private final String bonusNumber;

    public BonusNumber(String bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    @Override
    public boolean isNaturalNumber() {
        if (1 > Integer.parseInt(bonusNumber) || Integer.parseInt(bonusNumber) > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1이상 45이하의 자연수입니다.");
        }
        return true;
    }

    public boolean isExistedNumber(WinningNumber winningNumber) {
        if (winningNumber.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복됩니다.");
        }
        return true;
    }
}
