package lotto.service;

import lotto.domain.purchase.PurchaseDto;

public interface LottoService {
    void buyLotto(String amount);

    PurchaseDto getPurchaseDto();

    void assignWinningLotto(String numbers);
}
