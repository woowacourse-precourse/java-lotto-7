package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoPurchase {
    private final AmountValidator amountValidator = new AmountValidator();

    public int inputPurchaseAmount() {
        int lottoCount = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("구입금액을 입력해 주세요. : ");
            String input = Console.readLine().trim();

            try {
                amountValidator.validateInput(input);
                int lottoAmount = amountValidator.parseInputToInt(input);
                amountValidator.validateAmount(lottoAmount);
                lottoCount = lottoAmount / 1000;
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lottoCount;
    }
}