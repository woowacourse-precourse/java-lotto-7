package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.PurchaseAmount;

public class LottoResultCalculator {
    private final Lotto winningNumber;
    private final BonusNumber bonusNumber;
    private final LottoTicket lottoTicket;
    private final Map<String, Integer> winningLottos;

    public LottoResultCalculator(Lotto winningNumber, BonusNumber bonusNumber, LottoTicket lottoTicket) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.lottoTicket = lottoTicket;
        this.winningLottos = new HashMap<>();
    }

    public Map<String, Integer> getWinningLottos() {
        return winningLottos;
    }

    public double getRateOfReturn(PurchaseAmount purchaseAmount) {
        double totalPrize = 0;
        for (String key : winningLottos.keySet()) {
            int count = winningLottos.get(key);
            int prize = LottoRank.valueOf(key).getPrizeMoney();
            totalPrize += count * prize;
        }
        return (totalPrize / purchaseAmount.getValue()) * 100;
    }

    public void run() {
        List<Lotto> lottos = this.lottoTicket.getLottos();
        for (Lotto lotto : lottos) {
            LottoRank lottoResult = checkWinning(lotto);
            if (lottoResult != null) {
                int count = this.winningLottos.getOrDefault(lottoResult.name(), 0);
                this.winningLottos.put(lottoResult.name(), count + 1);
            }
        }
    }

    private LottoRank checkWinning(Lotto lotto) {
        int matchCount = matchingWinningNumberCount(lotto);
        boolean matchBonus = matchBonusNumber(lotto);
        return LottoRank.findRank(matchCount, matchBonus);
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
        return lotto.contains(bonusNumber.getValue());
    }
}
