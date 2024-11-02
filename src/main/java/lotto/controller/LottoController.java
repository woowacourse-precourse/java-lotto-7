package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.WinningNumber;
import lotto.service.LottoService;
import lotto.util.LottoUtils;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final InputController inputController;
    private final LottoService lottoService;
    private final OutputView outputView;

    public LottoController() {
        InputView inputView = new InputView();
        this.inputController = new InputController(inputView);
        this.lottoService = new LottoService();
        this.outputView = new OutputView();
    }

    public void run() {
        Money money = inputController.getMoney();
        int lottoCount = money.getLottoCount();
        List<Lotto> lottos = generateLottos(lottoCount);

        outputView.printLottoCount(lottoCount);
        outputView.printLottos(lottos);

        WinningNumber winningNumber = inputController.getWinningNumber();
        int[] matchCounts = lottoService.calculateStatistics(lottos, winningNumber);
        double yield = lottoService.calculateYield(money, matchCounts);

        outputView.printWinningStatistics(matchCounts);
        outputView.printYield(yield);
    }

    private List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(LottoUtils.generateRandomLottoNumbers()));
        }
        return lottos;
    }
}
