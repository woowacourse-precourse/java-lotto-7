package lotto.model;

public class LottoGame {
    private PurchasedLottos purchasedLottos;
    private PurchaseCost purchaseCost;
    private WinningNumbers winningNumbers;
    private int bonusNumber;
    private LottoResult lottoResult;

    public LottoGame(PurchasedLottos purchasedLottos, PurchaseCost purchaseCost
            , WinningNumbers winningNumbers, int bonusNumber) {
        this.purchasedLottos = purchasedLottos;
        this.purchaseCost = purchaseCost;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.lottoResult = new LottoResult();
    }
}
