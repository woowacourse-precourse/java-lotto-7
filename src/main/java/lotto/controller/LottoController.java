package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        try {
            List<Lotto> lottos = purchaseLottos();
            WinningLotto winningLotto = createWinningLotto();
            printWinningStatistics(lottos, winningLotto);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
    }

    private List<Lotto> purchaseLottos() {
        int amount = readPurchaseAmount();
        int count = lottoService.calculateLottoCount(amount);
        List<Lotto> lottos = lottoService.generateLottos(count);
        printPurchasedLottos(count, lottos);
        return lottos;
    }

    private int readPurchaseAmount() {
        try {
            String input = String.valueOf(InputView.readPurchaseAmount());
            lottoService.validatePurchaseAmount(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 올바르지 않습니다.");
        }
    }

    private void printPurchasedLottos(int count, List<Lotto> lottos) {
        OutputView.printPurchaseCount(count);
        OutputView.printLottos(lottos);
    }

    private WinningLotto createWinningLotto() {
        while (true) {
            try {
                List<Integer> winningNumbers = InputView.readWinningNumbers();
                int bonusNumber = InputView.readBonusNumber();
                return lottoService.createWinningLotto(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private void printWinningStatistics(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<LottoRank, Integer> statistics = lottoService.calculateWinningStatistics(lottos, winningLotto);
        OutputView.printWinningStatistics(statistics);

        double returnRate = lottoService.calculateReturnRate(statistics, lottos.size() * 1000);
        OutputView.printReturnRate(returnRate);
    }
}