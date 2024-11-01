package lotto.controller;

import static lotto.common.AppConstant.SPLIT_DELIMITER;

import java.util.Arrays;
import java.util.List;
import lotto.model.InputValidator;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoStatistic;
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

        WinningLotto winningLotto = inputWinningLotto();
        LottoStatistic lottoStatistic = lottoMachine.generateLottoStatistic(winningLotto, boughtLottoList);
        outputView.printLottoStatistic(lottoStatistic);
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

    private WinningLotto inputWinningLotto() {
        List<Integer> winningNumberList = attemptWinningNumber();
        Integer winningBonusNumber = attemptWinningBonusNumberExclude(winningNumberList);

        return lottoMachine.generateWinningLotto(winningNumberList, winningBonusNumber);
    }

    private List<Integer> attemptWinningNumber() {
        try {
            String rawWinningNumber = inputView.inputWinningNumber();
            inputValidator.validateInputWinningNumber(rawWinningNumber);
            String[] splitWinningNumber = rawWinningNumber.split(SPLIT_DELIMITER);

            return Arrays.stream(splitWinningNumber).map(Integer::parseInt).toList();
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception.getMessage());

            return attemptWinningNumber();
        }
    }

    private Integer attemptWinningBonusNumberExcluding(List<Integer> numberList) {
        try {
            String rawWinningBonusNumber = inputView.inputWinningBonusNumber();
            inputValidator.validateInputBonusNumber(rawWinningBonusNumber);
            int bonusNumber = Integer.parseInt(rawWinningBonusNumber);
            inputValidator.validateBonusNumberExcluding(bonusNumber, numberList);

            return bonusNumber;
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception.getMessage());

            return attemptWinningBonusNumberExcluding(numberList);
        }
    }
}
