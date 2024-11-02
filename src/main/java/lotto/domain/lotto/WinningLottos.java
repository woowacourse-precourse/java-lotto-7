package lotto.domain.lotto;

import lotto.domain.number.BonusNumber;
import lotto.domain.number.WinningNumbers;

import java.util.List;

public class WinningLottos {

    private final List<WinningLotto> winningLottos;

    private WinningLottos(final PurchasedLottos purchasedLottos, final WinningNumbers winningNumbers, final BonusNumber bonusNumber) {
        this.winningLottos = createWinningLottos(purchasedLottos, winningNumbers, bonusNumber);
    }

    public static WinningLottos of(final PurchasedLottos purchasedLottos, final WinningNumbers winningNumbers, final BonusNumber bonusNumber) {
        return new WinningLottos(purchasedLottos, winningNumbers, bonusNumber);
    }

    private List<WinningLotto> createWinningLottos(
            final PurchasedLottos purchasedLottos,
            final WinningNumbers winningNumbers,
            final BonusNumber bonusNumber
    ) {
        return purchasedLottos.getPurchasedLottos()
                .stream()
                .map(lotto -> WinningLotto.createWinningLotto(lotto, winningNumbers, bonusNumber))
                .filter(winningLotto -> winningLotto.getRank() != LottoRank.NONE)
                .toList();
    }

    public List<WinningLotto> getWinningLottos() {
        return winningLottos;
    }
}