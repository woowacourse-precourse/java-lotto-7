package lotto.service;

import static lotto.constants.LottoConstants.LOTTO_PRICE;

public class LottoServiceImpl implements LottoService {
    @Override
    public int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }
}
