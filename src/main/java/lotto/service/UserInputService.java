package lotto.service;

import lotto.util.InputValidator;

public class UserInputService {
    public int getPurchaseAmount(String inputAmount) {

        InputValidator.isNotNull(inputAmount);
        inputAmount = removeBlank(inputAmount);
        InputValidator.isNotEmpty(inputAmount);

        int purchaseAmount = parseInteger(inputAmount);
        InputValidator.isMinimumAmount(purchaseAmount);
        InputValidator.isMultipleOfThousand(purchaseAmount);

        return purchaseAmount;
    }

    private int parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요");
        }
    }

    private String removeBlank(String input) {
        return input.replaceAll(" ", "");
    }
}
