package lotto.adapter.in.console;

import lotto.adapter.in.console.dto.BonusNumberReq;
import lotto.adapter.in.console.dto.LottoResultRes;
import lotto.adapter.in.console.dto.PurchaseAmountReq;
import lotto.adapter.in.console.dto.WinningNumberReq;
import lotto.application.in.LottoUseCase;
import lotto.config.context.annotation.Handler;
import lotto.domain.round.LottoRound;
import lotto.domain.round.LottoRoundResult;

@Handler
public class LottoConsoleHandler {

    private final LottoUseCase lottoUseCase;

    public LottoConsoleHandler(LottoUseCase lottoUseCase) {
        this.lottoUseCase = lottoUseCase;
    }

    public void run() {
        LottoRound round = lottoUseCase.buyLotto(PurchaseAmountReq.read());
        LottoRoundResult result = lottoUseCase.checkResult(round, WinningNumberReq.read(), BonusNumberReq.read());

        LottoResultRes.of(result)
                .printEnter()
                .printPurchased(round)
                .printEnter()
                .printResult()
                .printProfit();
    }
}
