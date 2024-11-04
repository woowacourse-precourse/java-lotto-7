package lotto.view;

import java.util.List;
import lotto.common.LottoRank;
import lotto.domain.purchase.PurchaseDto;

public interface LottoView {
    String readPurchaseAmount();

    void displayLottoNumbers(PurchaseDto purchaseDto);

    String readWinningNumbers();

    String readBonusNumber();

    void displayLottoResult(List<LottoRank> lottoRanks, double profitRate);
}
