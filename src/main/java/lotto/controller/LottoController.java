package lotto.controller;

import java.util.List;
import lotto.model.Amount;
import lotto.model.LottoTicket;
import lotto.model.Rank;
import lotto.model.WinningTicket;
import lotto.view.InputView;
import lotto.view.OutputView;


public class LottoController {

    public void run() {
        Amount amount = Amount.from(InputView.readLottoPurchaseAmount());
        LottoTicket lottoTicket = purchase(amount);

        String lotto = InputView.readWinningLotto();
        String bonus = InputView.readWinningBonus();
        WinningTicket winningTicket = WinningTicket.of(lotto, bonus);

        List<Rank> ranks = compare(lottoTicket, winningTicket);
        long prizeSum = Rank.calcTotalPrize(ranks);
        rateOfReturn(amount.getValue(), prizeSum);
    }

    public LottoTicket purchase(Amount amount) {
        LottoTicket lottoTicket = LottoTicket.of(amount.getValue() / 1000);
        OutputView.printLottoCount(amount.getValue() / 1000);
        OutputView.printLottoTicket(lottoTicket);
        return lottoTicket;
    }

    public List<Rank> compare(LottoTicket lottoTicket, WinningTicket winningTicket) {
        List<Rank> ranks = lottoTicket.getRanks(winningTicket);
        OutputView.printRankCounts(Rank.groupByRankWithCount(ranks));
        return ranks;
    }

    public void rateOfReturn(long buy, long prizeSum) {
        OutputView.printRateOfReturn(buy, prizeSum);
    }
}
