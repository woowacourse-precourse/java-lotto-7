package lotto.controller;

import java.util.Arrays;
import java.util.List;
import lotto.model.InputValidator;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;
    private final LottoMachine lottoMachine;

    public LottoController(InputView inputView,
                           OutputView outputView,
                           InputValidator inputValidator,
                           LottoMachine lottoMachine) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidator = inputValidator;
        this.lottoMachine = lottoMachine;
    }

    public void run() {
        Integer money = inputMoney();

        List<Lotto> boughtLottoList = lottoMachine.buyLottoByPrice(money);
        outputView.printBoughtLottoList(boughtLottoList);
    }

    private Integer inputMoney() {
        try {
            String rawMoney = inputView.inputMoney();
            inputValidator.validateInputMoney(rawMoney);

            return Integer.parseInt(rawMoney);
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception.getMessage());

            return inputMoney();
        }
    }

    private void inputWinningLotto() {
        List<Integer> winningNumberList = attemptWinningNumber();

    }

    private List<Integer> attemptWinningNumber() {
        try {
            String rawWinningNumber = inputView.inputWinningNumber();
            inputValidator.validateInputWinningNumber(rawWinningNumber);
            String[] splitWinningNumber = rawWinningNumber.split(",");

            return Arrays.stream(splitWinningNumber).map(Integer::parseInt).toList();
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception.getMessage());

            return attemptWinningNumber();
        }
    }
}
