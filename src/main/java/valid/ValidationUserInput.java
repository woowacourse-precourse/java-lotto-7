package valid;

public class ValidationUserInput {
    static final String ERROR_MESSAGE = "[ERROR] ";
    ValidationForMany validationForMany = new ValidationForMany();
    ValidationForOne validationForOne = new ValidationForOne();

    public Integer validateMoney(String userInputMoney) {
        Integer validMoney = 0;
        try {
            validMoney = validationForOne.consistOfOnlyPositiveNumbers(userInputMoney);
            validationForOne.devisibleByThousands(validMoney);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + e.getMessage());
        }
        return validMoney;
    }

    public boolean validateWinningNumbers(String winningNumbers) {
        try {
            validationForMany.consistOfOnlySixPositiveNumbers(winningNumbers);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + e.getMessage());
        }
        return true;
    }

    public Integer validateBonusNumber(String bonusNumber) {
        Integer validBonusNumber = 0;
        try {
            validationForOne.consistOfOnlyPositiveNumbers(bonusNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + e.getMessage());
        }
        return validBonusNumber;
    }
}
