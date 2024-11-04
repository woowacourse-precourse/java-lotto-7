package valid;

public class ValidationUserInput {
    static final String ERROR_MESSAGE = "[ERROR] ";
    ValidationForMany validationForMany = new ValidationForMany();
    ValidationForOne validationForOne = new ValidationForOne();

    public boolean validateMoney(String money) {
        try {
            validationForOne.consistOfOnlyPositiveNumbers(money);
            validationForOne.devisibleByThousands(money);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + e.getMessage());
        }
        return true;
    }

    public boolean validateWinningNumbers(String winningNumbers) {
        try {
            validationForMany.consistOfOnlySixPositiveNumbers(winningNumbers);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + e.getMessage());
        }
        return true;
    }

    public boolean validateBonusNumber(String bonusNumber) {
        try {
            validationForOne.consistOfOnlyPositiveNumbers(bonusNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + e.getMessage());
        }
        return true;
    }
}
