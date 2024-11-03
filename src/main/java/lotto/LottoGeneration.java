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
}
