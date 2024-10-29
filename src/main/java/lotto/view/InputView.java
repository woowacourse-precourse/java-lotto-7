package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {

    public int inputPurchaseAmount() {
        String userInput = Console.readLine();
        return Integer.parseInt(userInput);
    }

    public Set<Integer> inputWinningNumbers() {
        String userInput = Console.readLine();
        return Arrays.stream(userInput.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }

    public int inputBonusNumber() {
        String userInput = Console.readLine();
        return Integer.parseInt(userInput);
    }
}
