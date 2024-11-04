package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.NumberValidator;
import lotto.validator.PurchaseAmountValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.model.constants.InputViewConstants.*;

public class InputView {

    public static long inputPurchaseAmount() {
        String inputAmount;
        do {
            System.out.println(PURCHASE_AMOUNT_PROMPT);
            inputAmount = Console.readLine().trim();
        } while (!PurchaseAmountValidator.checkValidPurchaseAmount(inputAmount));
        return Long.parseLong(inputAmount);
    }

    public static List<Integer> inputWinningNumbers() {
        String inputWinningNumbers;
        do {
            System.out.println(WINNING_NUMBERS_PROMPT);
            inputWinningNumbers = Console.readLine().trim();
        } while (!NumberValidator.checkValidWinningNumbers(inputWinningNumbers));
        return Arrays.stream(inputWinningNumbers.split(",")).map(Integer::valueOf).collect(Collectors.toList());
    }

    public static int inputBonusNumber(List<Integer> winningNumbers) {
        String inputBonusNumber;
        do {
            System.out.println(BONUS_NUMBER_PROMPT);
            inputBonusNumber = Console.readLine().trim();
        } while (!NumberValidator.checkValidBonusNumber(inputBonusNumber, winningNumbers));
        return Integer.parseInt(inputBonusNumber);
    }
}
