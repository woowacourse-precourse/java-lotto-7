package lotto.model;

public class BonusWinning {
    private int bonusNumber;

    public BonusWinning(String inputBonusNumber) {
        validate(inputBonusNumber);
        this.bonusNumber = Integer.parseInt(inputBonusNumber);
    }

    private void validate(String inputBonusNumber) {
        //1~45 숫자, winning과 중복 검사
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
