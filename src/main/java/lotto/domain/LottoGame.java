package lotto.domain;

import java.util.List;
import java.util.Set;

public class LottoGame {

    private final LottoPrice totalPrice;
    private final Lottos lottos;
    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;

    private LottoGame(LottoPrice totalPrice, Lottos lottos, Lotto winningNumbers, BonusNumber bonusNumber) {
        this.totalPrice = totalPrice;
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoGame of(LottoPrice totalPrice, Lottos lottos, Lotto winningNumbers, BonusNumber bonusNumber) {
        return new LottoGame(totalPrice, lottos, winningNumbers, bonusNumber);
    }

    public LottoPrice getTotalPrice() {
        return totalPrice;
    }

    public Lottos getLottos() {
        return lottos;
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
