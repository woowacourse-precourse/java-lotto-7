package lotto.controller;

import lotto.domain.*;
import lotto.service.*;
import lotto.strategy.AutoIssueStrategy;
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

        AutoIssueStrategy autoIssueStrategy = new AutoIssueStrategy();
        this.lottoIssueService = new LottoIssueService(autoIssueStrategy);

        this.lottoMatchService = new LottoMatchService();
        this.lottoProfitService = new LottoProfitService();
    }

    public void run() {
        LottoPurchaseMoney lottoPurchaseMoney = lottoInputService.inputLottoPurchaseMoney();

        LottoIssue lottoIssue = lottoIssueService.issue(lottoPurchaseMoney.getCount());
        lottoOuputService.outputIssueLotto(lottoIssue);

        Lotto lotto = lottoInputService.inputJackPotLotto();
        LottoBonusNumber lottoBonusNumber = lottoInputService.inputLottoBonusNumber();
        LottoJackpot lottoJackpot = new LottoJackpot(lotto, lottoBonusNumber);

        LottoMatch lottoMatch = lottoMatchService.match(lottoIssue, lottoJackpot);
        lottoOuputService.outPutLottoRank(lottoMatch);

        double profitPercent = lottoProfitService.calculateProfitPercent(lottoMatch, lottoPurchaseMoney);
        lottoOuputService.outPutProfitPercent(profitPercent);
    }
}
