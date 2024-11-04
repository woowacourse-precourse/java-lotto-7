package valid;

public class ValidationUserInput {
    ValidationForMany validationForMany = new ValidationForMany();
    ValidationForOne validationForOne = new ValidationForOne();

    public Integer validateMoney(String userInputMoney) {
        Integer validMoney = 0;
        try {
            validMoney = validationForOne.consistOfOnlyPositiveNumbers(userInputMoney);
            validationForOne.devisibleByThousands(validMoney);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return validMoney;
    }

    public boolean validateWinningNumbers(String winningNumbers) {
        try {
            validationForMany.consistOfOnlySixPositiveNumbers(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public Integer validateBonusNumber(String bonusNumber) {
        Integer validBonusNumber = 0;
        try {
            validationForOne.consistOfOnlyPositiveNumbers(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return validBonusNumber;
    }
}
