package convert;

import java.util.ArrayList;
import java.util.List;
import valid.Validate;

public class InputConvertor {

    private static void isNumber(String input) {
        Validate.isNumber(input);
    }

    public int convertPurchaseAmount(String inputPurchaseAmount) {
        isNumber(inputPurchaseAmount);

        int purchaseAmount = Integer.parseInt(inputPurchaseAmount);

        validatePurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        Validate.isPositiveNumber(purchaseAmount);
        Validate.isThousandUnit(purchaseAmount);
    }

    public List<Integer> convertInputWinningNumbers(String inputWinningNumbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        generateWinningNumbers(inputWinningNumbers, winningNumbers);
        validateWinningNumbers(winningNumbers);

        return winningNumbers;
    }

    private void generateWinningNumbers(String inputWinningNumbers, List<Integer> winningNumbers) {
        for (String inputWinningNumber : inputWinningNumbers.split(",")) {
            isNumber(inputWinningNumber);
            Integer winningNumber = Integer.valueOf(inputWinningNumber);
            Validate.isPositiveNumber(winningNumber);
            Validate.isOneBetweenFortyFive(winningNumber);
            winningNumbers.add(winningNumber);
        }
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        Validate.isDuplicated(winningNumbers);
        Validate.isSixNumbers(winningNumbers);
    }

    public int convertInputBonusNumber(String inputBonusNumber, List<Integer> winningNumbers) {
        Validate.isNumber(inputBonusNumber);
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        validateBonusNumber(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        Validate.isNotInWinningNumbers(winningNumbers, bonusNumber);
        Validate.isPositiveNumber(bonusNumber);
        Validate.isOneBetweenFortyFive(bonusNumber);
    }
}
