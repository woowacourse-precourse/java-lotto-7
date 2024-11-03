package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLotto;
import lotto.domain.LottoResult;
import lotto.utils.LottoNumbersGenerator;
import lotto.utils.Retry;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run(){
        LottoStore lottoStore = new LottoStore(new LottoNumbersGenerator());
        LottoTicket lottoTicket =  buyLotto(lottoStore);
        WinningLotto winningLotto = createWinningLotto();
        checkLottoResult(lottoTicket, winningLotto);
    }

    private LottoTicket buyLotto(final LottoStore lottoStore){
        int amount =  Retry.retryOnException(() -> InputView.inputPurchaseAmount());
        LottoTicket lottoTicket = Retry.retryOnException(() -> lottoStore.buyLottoTicket(amount));
        OutputView.printLottoTicketInformation(lottoTicket.getAllLottoNumbers(), lottoTicket.getLottoCount());
        return lottoTicket;
    }

    private WinningLotto createWinningLotto(){
        Lotto winLotto = Retry.retryOnException(() ->Lotto.from(InputView.inputWinNumbers()));
        return Retry.retryOnException(() -> WinningLotto.of(winLotto, InputView.inputBonusNumber()));
    }

    private void checkLottoResult(final LottoTicket lottoTicket, final WinningLotto winningLotto){
        LottoResult lottoResult = LottoResult.from(lottoTicket.checkRankings(winningLotto));
        double profit = lottoResult.calculateProfit(lottoTicket.getLottoTicketPrice());
        OutputView.printWinStatistics(profit, lottoResult.getRankingMap());
    }
}
