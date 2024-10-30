package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.validator.PurchaseAmountValidator;

public class InputView {

    private final PurchaseAmountValidator purchaseAmountValidator = new PurchaseAmountValidator();

    public int inputPurchaseAmount() {
        String userInput;
        do {
            userInput = Console.readLine();
        }
        while (purchaseAmountValidator.isNotValidPurchaseAmount(userInput));
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
