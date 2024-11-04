package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.validator.BonusNumberValidator;
import lotto.validator.PurchaseAmountValidator;
import lotto.validator.WinningNumbersValidator;

public class InputView {

    private final PurchaseAmountValidator purchaseAmountValidator;
    private final WinningNumbersValidator winningNumbersValidator;
    private final BonusNumberValidator bonusNumberValidator;

    public InputView(PurchaseAmountValidator purchaseAmountValidator, WinningNumbersValidator winningNumbersValidator,
                     BonusNumberValidator bonusNumberValidator) {
        this.purchaseAmountValidator = purchaseAmountValidator;
        this.winningNumbersValidator = winningNumbersValidator;
        this.bonusNumberValidator = bonusNumberValidator;
    }

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
        while (bonusNumberValidator.isNotValidBonusNumber(userInput, winningNumbers));
        return Integer.parseInt(userInput);

    }
}
