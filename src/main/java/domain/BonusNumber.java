package domain;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(String number) {

        Validate validate = new Validate();

        validate.validateContainsLetters(number);

        int bonusNumber = Integer.parseInt(number);
        validate.validateIsBonusNumberInRange(bonusNumber);

        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
