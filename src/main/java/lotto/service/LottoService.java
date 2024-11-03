package lotto.service;

import lotto.dto.Purchase;
import lotto.model.Lotto;
import lotto.view.OutputView;

import java.util.List;

public class LottoService {
    public List<Lotto> buyLottos(Purchase purchase) {
        OutputView outputView = new OutputView();

        outputView.printLottoAmount(purchase.getMoney());
        return null;
    }
}
