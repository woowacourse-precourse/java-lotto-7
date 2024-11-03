package lotto.service;

import lotto.domain.Purchase;

public class LottoServiceImpl implements LottoService {
    private Purchase purchase;

    @Override
    public void buyLotto(String amount) {
        purchase = new Purchase(amount);
    }
}
