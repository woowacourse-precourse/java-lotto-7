package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.PurchaseAmount;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoBonusNumber;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoWinningCriteria;

public class LottoResultCalculator {
    private final Lotto winningNumber;
    private final LottoBonusNumber lottoBonusNumber;
    private final LottoTicket lottoTicket;
    private final Map<String, Integer> winningLottos;

    public LottoResultCalculator(Lotto winningNumber, LottoBonusNumber lottoBonusNumber, LottoTicket lottoTicket) {
        this.winningNumber = winningNumber;
        this.lottoBonusNumber = lottoBonusNumber;
        this.lottoTicket = lottoTicket;
        this.winningLottos = new HashMap<>();
    }

    public Map<String, Integer> getWinningLottos() {
        return winningLottos;
    }

    public double getRateOfReturn(PurchaseAmount purchaseAmount) {
        double totalPrize = 0;
        if (purchaseAmount.getValue() == 0) {
            return totalPrize;
        }
        for (String key : winningLottos.keySet()) {
            int count = winningLottos.get(key);
            int prize = LottoWinningCriteria.valueOf(key).getPrizeMoney();
            totalPrize += count * prize;
        }
        return (totalPrize / purchaseAmount.getValue()) * 100;
    }

    public void run() {
        List<Lotto> lottos = this.lottoTicket.getLottos();
        for (Lotto lotto : lottos) {
            LottoWinningCriteria lottoResult = checkWinning(lotto);
            if (lottoResult != null) {
                int count = this.winningLottos.getOrDefault(lottoResult.name(), 0);
                this.winningLottos.put(lottoResult.name(), count + 1);
            }
        }
    }

    private LottoWinningCriteria checkWinning(Lotto lotto) {
        int matchCount = matchingWinningNumberCount(lotto);
        boolean matchBonus = matchBonusNumber(lotto);
        return LottoWinningCriteria.findRank(matchCount, matchBonus);
    }

    private int matchingWinningNumberCount(Lotto lotto) {
        int matchCount = 0;
        for (int winningNumber : winningNumber.getNumbers()) {
            if (lotto.contains(winningNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean matchBonusNumber(Lotto lotto) {
        return lotto.contains(lottoBonusNumber.getValue());
    }
}
