package lotto;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final List<Lotto> lottoTickets = new ArrayList<>();
    private final LottoManager lottoManager = new LottoManager();

    public void purchaseLotto(int money) {
        int count = money / Lotto.PRICE;
        for (int i = 0; i < count; i++) {
            lottoTickets.add(lottoManager.issue());
        }
    }

    public List<Rank> checkMyLotto(List<Integer> winningNumbers, int bonusNumber) {
        List<Rank> rankResult = new ArrayList<>();
        for (Lotto lotto : lottoTickets) {
            rankResult.add(lottoManager.getRank(lotto, winningNumbers, bonusNumber));
        }
        return rankResult;
    }

    public List<Lotto> getLottoTickets() {
        return new ArrayList<>(lottoTickets);
    }
}
