package lotto.view.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.money.PurchaseAmount;
import lotto.view.io.parser.InputStringParser;

public class InputHandler {

    private final InputStringParser inputStringParser = new InputStringParser();

    public PurchaseAmount getPurchaseAmount() {
        String input = Console.readLine();
        int purchaseAMount = inputStringParser.toInt(input);
        return PurchaseAmount.from(purchaseAMount);
    }

    public Lotto getWinningNumbers() {
        String input = Console.readLine();
        List<Integer> numbers = inputStringParser.toIntegerList(input);
        return Lotto.of(numbers);
    }

    public LottoNumber getBonusNumber() {
        String input = Console.readLine();
        int bonusNumber = inputStringParser.toInt(input);
        return new LottoNumber(bonusNumber);
    }

}
