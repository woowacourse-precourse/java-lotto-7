package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static int inputPurchasePrice() {
        String input = Console.readLine();
        checkInput(input);
        int purchasePrice = Integer.parseInt(input);
        return purchasePrice;
    }

    private static void checkInput(String input) {
        if (input == null || input.trim().isEmpty())
            throw new IllegalArgumentException("[ERROR] 입력이 비어있습니다.");
    }


}
