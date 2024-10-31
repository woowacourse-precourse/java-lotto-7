package lotto.service;

public class InputHandler {
    public static int purchaseAmountHandle(String input) {
        Validator.purchaseAmountValidate(input);
        int purchaseAmount = Integer.parseInt(input);

        return purchaseAmount/1000;
    }
}
