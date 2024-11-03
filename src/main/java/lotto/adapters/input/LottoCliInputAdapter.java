package lotto.adapters.input;

import static lotto.infrastructure.constants.AnnounceMessages.PROMPT_PURCHASE_AMOUNT;

import camp.nextstep.edu.missionutils.Console;
import lotto.application.port.output.OutputPort;
import lotto.application.validation.InputValidator;
import lotto.domain.amount.PurchaseAmount;

public class LottoCliInputAdapter {

    private final InputValidator inputValidator;
    private final OutputPort outputPort;

    public LottoCliInputAdapter(InputValidator inputValidator, OutputPort outputPort) {
        this.inputValidator = inputValidator;
        this.outputPort = outputPort;
    }

    public void run() {
        getInput();
    }

    private void getInput() {
        promptPurchaseAmount();
    }

    private PurchaseAmount promptPurchaseAmount() {
        outputPort.writeMessage(PROMPT_PURCHASE_AMOUNT.getMessage());
        String value = Console.readLine();
        inputValidator.validateAmount(value);

        return PurchaseAmount.from(value);
    }
}
