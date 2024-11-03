package domain;

public class BonusNumber {

    public int generateBonusNumber(String number) {

        Validate validate = new Validate();

        number = number.trim();
        validate.validateContainsLetters(number);

        int bonusNumber = Integer.parseInt(number);
        validate.validateIsBonusNumberInRange(bonusNumber);

        return bonusNumber;
    }
}
