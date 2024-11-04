package lotto.adapters.input.cli;

import static lotto.infrastructure.constants.AnnounceMessages.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.application.port.output.OutputPort;
import lotto.application.validation.InputValidator;
import lotto.domain.amount.PurchaseAmount;
import lotto.domain.lotto.WinningNumber;
import lotto.infrastructure.util.NumberParser;

public class LottoCliInputAdapter {

    private final InputValidator inputValidator;
    private final OutputPort outputPort;

    public LottoCliInputAdapter(InputValidator inputValidator, OutputPort outputPort) {
        this.inputValidator = inputValidator;
        this.outputPort = outputPort;
    }

    public void run() {
        purchaseLotto();
        getWinningNumber();
    }

    private void purchaseLotto() {
        PurchaseAmount purchaseAmount = promptPurchaseAmount();
    }

    private void getWinningNumber() {
        WinningNumber winningNumber = promptWinningNumber();
    }

    private PurchaseAmount promptPurchaseAmount() {
        outputPort.writeMessage(PROMPT_PURCHASE_AMOUNT.getMessage());
        String value = Console.readLine();
        inputValidator.validateAmount(value);

        return PurchaseAmount.from(NumberParser.parseNumber(value));
    }

    private WinningNumber promptWinningNumber() {
        List<Integer> numbers = promptNumbers();
        Integer bonusNumber = promptBonusNumber();

        return new WinningNumber(numbers, bonusNumber);
    }

    private List<Integer> promptNumbers() {
        outputPort.writeMessage(PROMPT_WINNING_NUMBER.getMessage());
        String winningNumber = Console.readLine();
        inputValidator.validateLotto(winningNumber);

        return NumberParser.parseLottoNumbers(winningNumber);
    }

    private Integer promptBonusNumber() {
        outputPort.writeNewline();
        outputPort.writeMessage(PROMPT_BONUS_NUMBER.getMessage());
        String bonusNumber = Console.readLine();

        return NumberParser.parseNumber(bonusNumber);
    }
}
