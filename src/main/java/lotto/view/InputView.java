package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public int inputPurchaseAmount() {
        String userInput = Console.readLine();
        return Integer.parseInt(userInput);
    }

    public List<Integer> inputWinningNumbers() {
        String userInput = Console.readLine();
        return Arrays.stream(userInput.split(","))
                .map(Integer::parseInt)
                .toList();
    }
}
