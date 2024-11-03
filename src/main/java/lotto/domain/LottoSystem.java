package lotto;

import lotto.domain.LottoProfitRate;
import lotto.domain.LottoResultDetails;
import lotto.domain.Lottos;
import lotto.domain.PurchasePrice;
import lotto.domain.WinningLottoNumber;
public class LottoSystem {

    public Lottos generateLottos(PurchasePrice purchasePrice) {
        int lottoQuantity = purchasePrice.getLottoTicketCount();
        return Lottos.of(lottoQuantity);
    }

    public LottoProfitRate generateLottoResults(Lottos lottos, WinningLottoNumber winningLottoNumber, PurchasePrice purchasePrice) {
        LottoResultDetails.count(lottos, winningLottoNumber);
        return LottoProfitRate.of(purchasePrice);
    }

}
