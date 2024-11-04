package lotto.result;

import lotto.draw.model.Draw;
import lotto.purchase.model.Purchase;
import lotto.result.model.LottoWinCount;
import lotto.result.model.Profit;

public class ResultController {
    ResultView resultView = new ResultView();
    
    public void lottoResult(final Purchase purchase, final Draw draw) {
        LottoWinCount lottoWinCount = new LottoWinCount(draw.getDrawNumbers(), draw.getBonusNumber(),
                purchase.getPurchasedLottoTickets());
        Profit profit = new Profit(lottoWinCount.getLottoWinCount(), purchase.getPayment());
        resultView.displayLottoWins(lottoWinCount.getLottoWinCount());
        resultView.displayProfit(profit.getProfit());
    }
}
