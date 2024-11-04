package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.WinningNumber;
import lotto.service.LottoService;
import lotto.service.OutputService;
import lotto.util.LottoUtils;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final InputController inputController;
    private final LottoService lottoService;
    private final OutputController outputController;

    public LottoController() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        this.inputController = new InputController(inputView);
        this.lottoService = new LottoService();
        this.outputController = new OutputController(new OutputService(), outputView);
    }

    public void run() {
        Money money = inputController.getMoney();
        int lottoCount = money.getLottoCount();
        List<Lotto> lottos = generateLottos(lottoCount);

        outputController.displayLottoCount(lottoCount);
        outputController.displayLottos(lottos);

        WinningNumber winningNumber = inputController.getWinningNumber();
        int[] matchCounts = lottoService.calculateStatistics(lottos, winningNumber);
        double yield = lottoService.calculateYield(money, matchCounts);

        outputController.displayWinningStatistics(matchCounts);
        outputController.displayYield(yield);
    }

    List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(LottoUtils.generateRandomLottoNumbers()));
        }
        return lottos;
    }
}
