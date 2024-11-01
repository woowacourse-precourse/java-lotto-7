package convert;

import java.util.ArrayList;
import java.util.List;
import valid.Validate;

public class InputConvertor {

    public String convertPurchaseAmount(String inputPurchaseAmount) {
        isNumber(inputPurchaseAmount);

        int purchaseAmount = Integer.parseInt(inputPurchaseAmount);

        validatePurchaseAmount(purchaseAmount);
        return inputPurchaseAmount;
    }

    private void isNumber(String input) {
        Validate.isNumber(input);
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

    private static void validateWinningNumbers(List<Integer> winningNumbers) {
        Validate.isDuplicated(winningNumbers);
        Validate.isSixNumbers(winningNumbers);
    }

    private void generateWinningNumbers(String inputWinningNumbers, List<Integer> winningNumbers) {
        for(String inputWinningNumber : inputWinningNumbers.split(",")) {
            isNumber(inputWinningNumber);
            Integer winningNumber = Integer.valueOf(inputWinningNumber);
            Validate.isOneBetweenFortyFive(winningNumber);
            winningNumbers.add(winningNumber);
        }
    }
}
