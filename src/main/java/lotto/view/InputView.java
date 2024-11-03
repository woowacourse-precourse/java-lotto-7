package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.NumberValidator;
import lotto.validator.PurchaseAmountValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";

    public static long inputPurchaseAmount() throws IllegalArgumentException {
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

    public static int inputBonusNumber() {
        String inputBonusNumber;
        do {
            System.out.println(BONUS_NUMBER_PROMPT);
            inputBonusNumber = Console.readLine().trim();
        } while (!NumberValidator.checkValidBonusNumber(inputBonusNumber));
        return Integer.parseInt(inputBonusNumber);
    }
}
