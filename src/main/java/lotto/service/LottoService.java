package lotto.service;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoPrize;
import lotto.model.WinnerLotto;

public class LottoService {
    public LottoMachine createLottoMachine(int amount) {
        return new LottoMachine(amount);
    }

    public WinnerLotto createWinnerLotto(Lotto winnerNumbers, int bonus) {
        return new WinnerLotto(winnerNumbers, bonus);
    }

    public long calculatePrize(List<Lotto> lottoTickets, WinnerLotto winnerLotto) {
        long totalPrize = 0;

        for (Lotto lotto : lottoTickets) {
            int matchCount = getMatchingNumbers(lotto, winnerLotto);
            totalPrize += prize(matchCount);
        }
        return totalPrize;
    }

    private int getMatchingNumbers(Lotto lotto, WinnerLotto winnerLotto) {
        int matchCount = 0;
        List<Integer> winnerNumbers = winnerLotto.getLotto().getNumbers();

        for (int number : lotto.getNumbers()) {
            if (winnerNumbers.contains(number)) {
                matchCount++;
            }
        }

        if (matchCount == 5 && lotto.getNumbers().contains(winnerLotto.getBonus())) {
            matchCount = 55;
        }

        return matchCount;
    }

    private long prize(int matchCount) {
        return LottoPrize.getPrizeByRank(matchCount);
    }

    public double totalReturn(LottoMachine lottoMachine, long prize) {
        double amount = lottoMachine.totalAmonut();

        return Math.round((double) prize / amount * 1000.0) / 10.0;

    }
}
