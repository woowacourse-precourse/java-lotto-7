package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);

        int purchaseAmount = 0;
        try {
            purchaseAmount = Parser.parsePurchaseAmount(Console.readLine());
            Validator.validatePurchaseAmount(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPurchaseAmount();
        }

        return purchaseAmount;
    }

    public static List<Integer> inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);

        List<Integer> winningNumber = null;
        try {
            winningNumber = Parser.parseWinningNumber(Console.readLine());
            Validator.validateWinningNumber(winningNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumber();
        }

        return winningNumber;
    }

    public static Integer inputBonusNumber(List<Integer> winningNumber) {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);

        int bonusNumber = 0;
        try {
            bonusNumber = Parser.parseBonusNumber(Console.readLine());
            Validator.validateBonusNumber(bonusNumber);
            Validator.validateDuplicateWith(winningNumber, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber(winningNumber);
        }

        return bonusNumber;
    }
}
