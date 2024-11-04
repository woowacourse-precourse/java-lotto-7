package lotto;

import domain.Lotto;
import domain.Rank;
import view.LottoView;

import java.util.List;

public class LottoController {
    private final LottoView view;
    private final Rank rank;

    public LottoController(LottoView view) {
        this.view = view;
        this.rank = new Rank();
    }

    public void start() {
        int amount = view.getPurchaseAmount();
        List<Lotto> purchasedLottos = rank.purchaseLotto(amount);
        view.displayPurchasedLottos(purchasedLottos);

        view.setPurchasedLottos(purchasedLottos);

        List<Integer> winningNumbers = view.getWinningNumbers().getNumbers();
        int bonusNumber = view.getBonusNumber();

        rank.checkWinning(purchasedLottos, winningNumbers, bonusNumber);
        view.displayStatistics(rank.getWinnings());
        view.displayReturnRate(amount, rank.calculateTotalWinnings());
    }
}
