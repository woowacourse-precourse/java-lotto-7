package lotto.service;

import lotto.domain.lotto.LottoDto;
import lotto.domain.purchase.PurchaseDto;

public interface LottoService {
    void buyLotto(String amount);

    PurchaseDto getPurchaseDto();

    LottoDto getWinningLottoDto();

    void assignWinningLotto(String numbers);
}
