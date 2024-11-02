package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final int lottoPrice;
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(int lottoPrice, InputView inputView, OutputView outputView, LottoService lottoService) {
        this.lottoPrice = lottoPrice;
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        int cost = inputView.readCost(lottoPrice);
        int issueCount = lottoService.getIssueCount(cost, lottoPrice);

        List<Lotto> issuedLotto = lottoService.issueLotto(issueCount);

        outputView.printTotalIssuedLotto(issuedLotto);

        Lotto winningNumbers = inputView.readWinningNumbers();
        WinningLotto winningLotto = inputView.readBonusNumber(winningNumbers);

        List<LottoRank> lottoRanks = lottoService.rankLotto(issuedLotto, winningLotto);

        outputView.printWinningStatus(lottoRanks, lottoPrice);

        inputView.terminate();
    }
}
