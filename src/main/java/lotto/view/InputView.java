package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);

        int purchaseAmount = Parser.parsePurchaseAmount(Console.readLine());
        Validator.validatePurchaseAmount(purchaseAmount);

        return purchaseAmount;
    }

    public static List<Integer> inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);

        List<Integer> winningNumber = Parser.parseWinningNumber(Console.readLine());
        Validator.validateWinningNumber(winningNumber);

        return winningNumber;
    }

    public static Integer inputBonusNumber(List<Integer> winningNumber) {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);

        Integer bonusNumber = Parser.parseBonusNumber(Console.readLine());
        Validator.validateBonusNumber(bonusNumber);
        Validator.validateDuplicateWith(winningNumber, bonusNumber);

        return bonusNumber;
    }
}
