package lotto.Service;

import java.util.List;
import lotto.Domain.LottoPrizeMoney;
import lotto.Domain.LottoWinnings;

public class LottoService {
    private LottoWinnings lottoWinnings;

    public LottoService(LottoWinnings lottoWinnings) {
        this.lottoWinnings = lottoWinnings;
    }

    public int totalPrizeMoney() {
        List<Integer> matchNumberCount = lottoWinnings.findMatchNumberCount();
        int totalPrize = 0;

        for (int i = 1; i < matchNumberCount.size(); i++) {
            LottoPrizeMoney prize = LottoPrizeMoney.fromRank(i);
            int count = matchNumberCount.get(i);

            if (count > 0) {
                totalPrize += count * prize.getPrizeMoney();
            }
        }

        return totalPrize;
    }

    public double earningRate(int totalInvestment) {
        return ((double) totalPrizeMoney() / totalInvestment) * 100;
    }
}
