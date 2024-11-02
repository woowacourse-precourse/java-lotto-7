package lotto.controller;

import lotto.domain.*;
import lotto.service.*;
import lotto.strategy.AutoIssueStrategy;
import lotto.strategy.IssueStrategy;
import lotto.view.LottoView;

public class LottoController {

    private final LottoInputService lottoInputService;
    private final LottoOuputService lottoOuputService;
    private final LottoIssueService lottoIssueService;
    private final LottoMatchService lottoMatchService;
    private final LottoProfitService lottoProfitService;

    public LottoController() {
        LottoView lottoView = new LottoView();
        this.lottoInputService = new LottoInputService(lottoView);
        this.lottoOuputService = new LottoOuputService(lottoView);

        IssueStrategy autoIssueStrategy = new AutoIssueStrategy();
        this.lottoIssueService = new LottoIssueService(autoIssueStrategy);

        this.lottoMatchService = new LottoMatchService();
        this.lottoProfitService = new LottoProfitService();
    }

    public void run() {
        LottoPurchaseMoney lottoPurchaseMoney = lottoInputService.inputLottoPurchaseMoney();

        LottoIssue lottoIssue = lottoIssueService.issue(lottoPurchaseMoney.getCount());
        lottoOuputService.outputLottoIssue(lottoIssue);

        Lotto lotto = lottoInputService.inputLottoJackPot();
        LottoBonusNumber lottoBonusNumber = lottoInputService.inputLottoBonusNumber();
        LottoJackpot lottoJackpot = new LottoJackpot(lotto, lottoBonusNumber);

        LottoMatch lottoMatch = lottoMatchService.match(lottoIssue, lottoJackpot);
        lottoOuputService.outputLottoMatch(lottoMatch);

        double profitPercent = lottoProfitService.calculateProfitPercent(lottoMatch, lottoPurchaseMoney);
        lottoOuputService.outputProfitPercent(profitPercent);
    }
}
