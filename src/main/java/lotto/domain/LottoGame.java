package lotto.domain;

public class LottoGame {

    private final LottoPrice totalPrice;
    private final Lottos purchasedLottos;
    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;

    private LottoGame(LottoPrice totalPrice, Lottos purchasedLottos, Lotto winningNumbers, BonusNumber bonusNumber) {
        this.totalPrice = totalPrice;
        this.purchasedLottos = purchasedLottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoGame of(LottoPrice totalPrice, Lottos lottos, Lotto winningNumbers, BonusNumber bonusNumber) {
        return new LottoGame(totalPrice, lottos, winningNumbers, bonusNumber);
    }

    public LottoPrice getTotalPrice() {
        return totalPrice;
    }

    public Lottos getPurchasedLottos() {
        return purchasedLottos;
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
