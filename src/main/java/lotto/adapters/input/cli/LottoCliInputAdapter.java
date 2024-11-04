package lotto.adapters.input.cli;

import static lotto.infrastructure.constants.AnnounceMessages.PROMPT_BONUS_NUMBER;
import static lotto.infrastructure.constants.AnnounceMessages.PROMPT_PURCHASE_AMOUNT;
import static lotto.infrastructure.constants.AnnounceMessages.PROMPT_WINNING_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.application.dto.request.EvaluateWinningLottoRequest;
import lotto.application.dto.request.PurchaseLottoRequest;
import lotto.application.dto.response.EvaluateWinningLottoResponse;
import lotto.application.dto.response.PurchaseLottoResponse;
import lotto.application.port.input.EvaluateWinningLottoUsecase;
import lotto.application.port.input.PurchaseLottoUsecase;
import lotto.application.port.output.OutputPort;
import lotto.application.validation.InputValidator;
import lotto.domain.amount.PurchaseAmount;
import lotto.domain.lotto.WinningNumber;
import lotto.infrastructure.util.NumberParser;

public class LottoCliInputAdapter {

    private final InputValidator inputValidator;
    private final OutputPort outputPort;
    private final PurchaseLottoUsecase purchaseLottoUsecase;
    private final EvaluateWinningLottoUsecase evaluateWinningLottoUsecase;

    public LottoCliInputAdapter(
        InputValidator inputValidator,
        OutputPort outputPort,
        PurchaseLottoUsecase purchaseLottoUsecase,
        EvaluateWinningLottoUsecase evaluateWinningLottoUsecase
    ) {
        this.inputValidator = inputValidator;
        this.outputPort = outputPort;
        this.purchaseLottoUsecase = purchaseLottoUsecase;
        this.evaluateWinningLottoUsecase = evaluateWinningLottoUsecase;
    }

    public void run() {
        purchaseLotto();
        analyzeLottoResult();
    }

    private void purchaseLotto() {
        PurchaseAmount purchaseAmount = promptPurchaseAmount();
        PurchaseLottoResponse purchaseLottoResponse = purchaseLottoUsecase.execute(
            new PurchaseLottoRequest(purchaseAmount)
        );

        outputPort.writeNewline();
        outputPort.writeResponse(purchaseLottoResponse);
    }

    private PurchaseAmount promptPurchaseAmount() {
        outputPort.writeMessage(PROMPT_PURCHASE_AMOUNT.getMessage());
        return readPurchaseAmount();
    }

    private PurchaseAmount readPurchaseAmount() {
        try {
            String value = Console.readLine();
            inputValidator.validateAmount(value);
            return PurchaseAmount.from(NumberParser.parseNumber(value));
        } catch (IllegalArgumentException exception) {
            outputPort.writeMessage(exception.getMessage());
            return readPurchaseAmount();
        }
    }

    private void analyzeLottoResult() {
        WinningNumber winningNumber = promptWinningNumber();
        EvaluateWinningLottoResponse evaluateWinningLottoResponse = evaluateWinningLottoUsecase.execute(
            new EvaluateWinningLottoRequest(winningNumber)
        );

        outputPort.writeNewline();
        outputPort.writeResponse(evaluateWinningLottoResponse);
    }

    private WinningNumber promptWinningNumber() {
        return readWinningNumber();
    }

    private WinningNumber readWinningNumber() {
        try {
            List<Integer> numbers = requestWinningNumber();
            Integer bonusNumber = requestBonusNumber();

            return WinningNumber.of(numbers, bonusNumber);
        } catch (IllegalArgumentException exception) {
            outputPort.writeMessage(exception.getMessage());
            return readWinningNumber();
        }
    }

    private List<Integer> requestWinningNumber() {
        outputPort.writeMessage(PROMPT_WINNING_NUMBER.getMessage());
        String winningNumber = Console.readLine();
        inputValidator.validateLotto(winningNumber);

        return NumberParser.parseLottoNumbers(winningNumber);
    }

    private Integer requestBonusNumber() {
        outputPort.writeNewline();
        outputPort.writeMessage(PROMPT_BONUS_NUMBER.getMessage());
        String bonusNumber = Console.readLine();

        return NumberParser.parseNumber(bonusNumber);
    }
}
