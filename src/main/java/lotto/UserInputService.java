package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserInputService {
    public int getPurchaseAmount() {
        while(true) {
            System.out.println("구입금액을 입력해 주세요.");
            String inputAmount = Console.readLine();
            inputAmount = inputAmount.replaceAll(" ", "");

            try {
                InputValidator.isNotEmpty(inputAmount);
                int purchaseAmount = parseInteger(inputAmount);

                InputValidator.isMinimumAmount(purchaseAmount);
                InputValidator.isMultipleOfThousand(purchaseAmount);
                return purchaseAmount;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int parseInteger(String input) {
        int result;
        try {
            result = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요");
        }
        return result;
    }
}
