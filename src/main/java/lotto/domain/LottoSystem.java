package lotto.domain;

public class LottoSystem {

    public Lottos generateLottos(PurchasePrice purchasePrice) {
        int lottoQuantity = purchasePrice.getLottoTicketCount();
        return Lottos.of(lottoQuantity);
    }

    public LottoProfitRate generateLottoResults(Lottos lottos, WinningLottoNumber winningLottoNumber,
                                                PurchasePrice purchasePrice) {
        LottoResultDetails.count(lottos, winningLottoNumber);
        return LottoProfitRate.of(purchasePrice);
    }
}
