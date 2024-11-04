package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static String getInputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine().trim();
    }

    public static int getPurchaseAmount() {
        String input = getInputPurchaseAmount();
        return validatePurchaseAmount(input);
    }

    private static int validatePurchaseAmount(String input) {
        try {
            int amount = Integer.parseInt(input);
            if ((amount % 1000) != 0) {
                throw new IllegalArgumentException("[ERROR] 숫자는 1,000원 단위로 입력해 주세요.");
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }
}
