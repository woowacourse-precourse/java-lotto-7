package lotto.service;

import static lotto.model.LottoStore.LOTTO_PRICE;

import java.util.Map;
import lotto.enums.LottoRank;
import lotto.model.LottoResult;
import lotto.model.LottoStore;
import lotto.model.LottoTicket;
import lotto.model.WinningLotto;

public class LottoService {

    public LottoTicket createLottoTicket(String purchaseMoney) {
        return LottoStore.makeLottoTicket(purchaseMoney);
    }

    public WinningLotto createWinningLotto(String winningNumber) {
        return WinningLotto.create(winningNumber);
    }

    public void addBonusNumber(WinningLotto winningLotto, String bonusNumber) {
        winningLotto.addBonusNumber(bonusNumber);
    }

    public LottoResult compareLotto(LottoTicket lottoTicket, WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult();
        lottoResult.compare(lottoTicket, winningLotto);
        return lottoResult;
    }

    public double calculateEarnings(Map<LottoRank, Integer> rankResults, LottoTicket lottoTicket) {
        int purchaseMoney = lottoTicket.getLottosCount() * LOTTO_PRICE;
        long totalEarnings = 0L;
        for (LottoRank rank : rankResults.keySet()) {
            int count = rankResults.get(rank);
            totalEarnings += rank.getPrize() * count;
        }
        double earningsRate = (double) totalEarnings / purchaseMoney * 100;
        return Math.round(earningsRate * 10) / 10.0;
    }
}
