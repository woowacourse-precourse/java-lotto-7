package lotto.controller;

import static lotto.view.ErrorPrinter.printError;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import lotto.exception.ExceptionCode;
import lotto.exception.LottoException;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private static final int MAX_TRY = 5;

    private final LottoService lottoService = new LottoService();

    public void run() {

        int inputMoney = readMoney();
        List<Lotto> myLottos = buyLotto(inputMoney);
        OutputView.showLottoNumbers(myLottos);

        WinningNumbers winningNumbers = getWinningNumbers();
        int[] result = lottoService.compareNumbers(myLottos, winningNumbers);
        float profit = lottoService.calculateProfit(result, myLottos);
        OutputView.showWinningResult(result);
        OutputView.showProfitRatio(profit);

    }

    private int readMoney() {
        for (int i=0; i<MAX_TRY; i++) {
            try {
                return InputView.readMoney();
            } catch (RuntimeException e) {
                printError(e.getMessage());
            }
        }
        throw new LottoException(ExceptionCode.MAX_TRY_ERROR);
    }

    private List<Lotto> buyLotto(int money) {
        for (int i=0; i<MAX_TRY; i++) {
            try {
                return lottoService.buyLotto(money);
            } catch (RuntimeException e) {
                printError(e.getMessage());
            }
        }
        throw new LottoException(ExceptionCode.MAX_TRY_ERROR);
    }

    private WinningNumbers getWinningNumbers() {
        for (int i=0; i<MAX_TRY; i++) {
            try {
                return lottoService.getWinningNumbers();
            } catch (RuntimeException e) {
                printError(e.getMessage());
            }
        }
        throw new LottoException(ExceptionCode.MAX_TRY_ERROR);
    }
}
