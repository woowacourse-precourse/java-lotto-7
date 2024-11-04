package lotto.view;

import lotto.domain.purchase.PurchaseDto;

public interface LottoView {
    String readPurchaseAmount();

    void displayLottoNumbers(PurchaseDto purchaseDto);

    String readWinningNumbers();
}
