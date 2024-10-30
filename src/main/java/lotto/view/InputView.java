package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.validator.PurchaseAmountValidator;
import lotto.validator.WinningNumbersValidator;

public class InputView {

    private final PurchaseAmountValidator purchaseAmountValidator = new PurchaseAmountValidator();
    private final WinningNumbersValidator winningNumbersValidator = new WinningNumbersValidator();

    public int inputPurchaseAmount() {
        String userInput;
        do {
            userInput = Console.readLine();
        }
        while (purchaseAmountValidator.isNotValidPurchaseAmount(userInput));
        return Integer.parseInt(userInput);
    }


    public Set<Integer> inputWinningNumbers() {
        String userInput;
        do {
            userInput = Console.readLine();
        }
        while (winningNumbersValidator.isNotValidWinningNumbers(userInput));
        return Arrays.stream(userInput.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }

    public int inputBonusNumber(Set<Integer> winningNumbers) {
        String userInput;
        do {
            userInput = Console.readLine();
        }
        while (winningNumbersValidator.isNotValidWinningNumbers(userInput));
        return Integer.parseInt(userInput);

    }
}
