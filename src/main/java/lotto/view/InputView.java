package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.domain.BonusNumber;
import lotto.domain.PurchaseAmount;
import lotto.validator.InputValidator;

import java.util.Arrays;

public class InputView {

    private static final String COMMA = ",";

    public PurchaseAmount readPurchasePrice() {
        String input = Console.readLine();
        InputValidator.validateNumber(input);
        return new PurchaseAmount(Integer.parseInt(input));
    }

    public Lotto readWinningNumber() {
        String input = Console.readLine();
        InputValidator.validateWinningNumberFormat(input);
        return new Lotto(
                Arrays.stream(input.split(COMMA))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .toList()
        );
    }

    public BonusNumber readBonusNumber() {
        String input = Console.readLine();
        InputValidator.validateNumber(input);
        return new BonusNumber(Integer.parseInt(input));
    }
}
