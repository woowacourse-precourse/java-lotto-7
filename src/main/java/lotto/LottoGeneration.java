package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGeneration {
    public static int inputPurchaseAmount() {
        while (true) {
            String input = Console.readLine().trim();
            int amount = parseInputToInteger(input);
            if (amount != -1) {
                return amount;
            }
        }
    }

    private static int parseInputToInteger(String input) {
        try {
            validatePurchaseAmount(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }
}
