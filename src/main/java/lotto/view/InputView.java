package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.validator.BonusNumberValidator;
import lotto.util.validator.PurchaseAmountValidator;
import lotto.util.validator.WinnerNumberValidator;

public class InputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNER_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        String input = Console.readLine();
        return PurchaseAmountValidator.validate(input);
    }

    public static List<Integer> winnerNumber() {
        System.out.println(WINNER_NUMBER_MESSAGE);
        String input = Console.readLine();
        return WinnerNumberValidator.validate(input);
    }

    public static int inputBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();
        return BonusNumberValidator.validate(input);
    }
}
