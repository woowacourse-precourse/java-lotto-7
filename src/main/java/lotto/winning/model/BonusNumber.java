package lotto.winning.model;

public class BonusNumber {
    private int bonusNumber;


    public int getBonusNumber(String inputBonusNumber) {
        validateBonusNumber(inputBonusNumber);
        this.bonusNumber = Integer.parseInt(inputBonusNumber);
        return bonusNumber;
    }

    private void validateBonusNumber(String inputBonusNumber) {
        //1~45 숫자, winning과 중복 검사
    }
}
