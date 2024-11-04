package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    private final LottoService lottoService = new LottoService();

    public void run() {

        int inputMoney = InputView.readMoney();
        List<Lotto> myLottos = lottoService.buyLotto(inputMoney);
        OutputView.showLottoNumbers(myLottos);

        List<Integer> inputNumbers = InputView.readWinningNumbers();
        int inputBonusNumber = InputView.readBonusNumber();
        int[] result = lottoService.compareNumbers(myLottos, inputNumbers, inputBonusNumber);
        float profit = lottoService.calculateProfit(result, myLottos);
        OutputView.showWinningResult(result);
        OutputView.showProfitRatio(profit);

    }
}
