package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.PurchaseAmountValidator;

public class InputView {
    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";

    public static long inputLottoPurchaseAmount() {
        String inputAmount;
        do {
            System.out.println(PURCHASE_AMOUNT_PROMPT);
            inputAmount = Console.readLine().trim();
        } while (!PurchaseAmountValidator.checkValidPurchaseAmount(inputAmount));
        return Long.parseLong(inputAmount);
    }

    public static void inputWinningNumbers() {
        String inputWinningNumbers;
        do {
            System.out.println(WINNING_NUMBERS_PROMPT);
        } while ()
    }

    public static void inputBonusNumber() {
        System.out.println(BONUS_NUMBER_PROMPT);
    }
}
