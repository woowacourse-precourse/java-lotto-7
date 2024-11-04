package lotto.ui.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.model.domain.BonusNumber;
import lotto.model.domain.PurchaseAmount;

public class InputView {
    private final InputParser parser;

    public InputView(InputParser parser) {
        this.parser = parser;
    }

    public PurchaseAmount getPurchaseAmount() {
        String amount = Console.readLine();
        return parser.parsePurchaseAmount(amount);
    }

    public List<Integer> getWinningNumbers(String delimiter) {
        String winningNumbers = Console.readLine();
        return parser.parseWinningNumbers(delimiter, winningNumbers);
    }

    public BonusNumber getBonusNumber() {
        String bonusNumber = Console.readLine();
        return parser.parseBonusNumber(bonusNumber);
    }

    public void close() {
        Console.close();
    }
}
