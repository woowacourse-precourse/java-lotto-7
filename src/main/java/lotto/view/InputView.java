package lotto.view;

import static lotto.utils.Constant.BONUS_NUMBER_INPUT_MESSAGE;
import static lotto.utils.Constant.PURCHASE_AMOUNT_INPUT_MESSAGE;
import static lotto.utils.Constant.WINNING_NUMBER_INPUT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.utils.parser.BonusNumberParser;
import lotto.utils.parser.PurchaseAmountParser;
import lotto.utils.parser.WinningNumberParser;

public class InputView {
    private final PurchaseAmountParser purchaseAmountParser;
    private final WinningNumberParser winningNumberParser;
    private final BonusNumberParser bonusNumberParser;

    public InputView(
            PurchaseAmountParser purchaseAmountParser,
            WinningNumberParser winningNumberParser,
            BonusNumberParser bonusNumberParser
    ) {
        this.purchaseAmountParser = purchaseAmountParser;
        this.winningNumberParser = winningNumberParser;
        this.bonusNumberParser = bonusNumberParser;
    }


    public int inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);

        while (true) {
            String userInput = Console.readLine();

            try {
                return purchaseAmountParser.parse(userInput);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public List<Integer> inputWinningNumber() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);

        while (true) {
            String userInput = Console.readLine();

            try {
                return winningNumberParser.parse(userInput);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public int inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);

        while (true) {
            String userInput = Console.readLine();

            try {
                return bonusNumberParser.parse(userInput, winningNumbers);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
