package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Budget;

public class LottiesFactory {
    private static final long LOTTO_PRICE = 1000L;

    public static Lotties purchaseLotties(Budget budget) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (long i = 0L; i < budget.getAmount() / LOTTO_PRICE; i++) {
            lottoTickets.add(Lotto.quickPick());
        }
        return Lotties.of(lottoTickets);
    }
}
