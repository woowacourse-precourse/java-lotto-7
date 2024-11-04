package lotto.service;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoPrize;
import lotto.model.User;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;

    public LottoMachine createLottoMachine(int amount) {
        return new LottoMachine(amount);
    }

    public User createUser(List<Lotto> lottoTickets, Lotto winnerLotto, int bonus) {
        return new User(lottoTickets, winnerLotto, bonus);
    }

    public long calculatePrize(User user) {
        long totalPrize = 0;

        for (Lotto lotto : user.getLottoTickets()) {
            int matchCount = getMatchingNumbers(user, lotto);
            totalPrize += prize(matchCount);
        }
        return totalPrize;
    }

    private int getMatchingNumbers(User user, Lotto lotto) {
        int matchCount = 0;
        List<Integer> winnerLotto = user.getWinnerLotto().getNumbers();

        for (int number : lotto.getNumbers()) {
            if (winnerLotto.contains(number)) {
                matchCount++;
            }
        }

        if (matchCount == 5 && lotto.getNumbers().contains(user.getBonus())) {
            matchCount = 55;
        }

        return matchCount;
    }

    private long prize(int matchCount) {
        return LottoPrize.getPrizeByRank(matchCount);
    }

    public double totalReturn(User user, long prize) {
        int amount = user.getLottoTickets().size() * LOTTO_PRICE;

        return Math.round(prize / amount) * 100.0;
    }
}
