package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.validation.InputValidator;

public class InputReader {

    public int totalPurchaseAmount() {
        int amount = stringToInt(readInput());
        InputValidator.purchaseAmountValidate(amount);
        return amount / 1000;
    }

    public List<String> winningNumbers() {
        String input = readInput();
        return List.of(input.split(",")); // 여기까지 일단 진행 ,,,,
    }

    private String readInput() {
        return Console.readLine();
    }

    private int stringToInt(String string) {
        return Integer.parseInt(string);
    }
}
