package lotto.controller;

import lotto.domain.*;
import lotto.service.LottoService;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private final LottoService lottoService = new LottoService();

    public void run() {
        try {
            PurchasedPrice purchasedPrice = new PurchasedPrice(InputView.readNumber());

            Lotto winningNumbers = new Lotto(InputView.readWinningNumbers());
            BonusNumber bonusNumber = new BonusNumber(InputView.readNumber());

            Lottos purchasedLottos = generate(purchasedPrice);

        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private Lottos generate(PurchasedPrice purchasedPrice) {
        LottoCount lottoCount = new LottoCount(purchasedPrice.getPurchasedPrice());
        return lottoService.generateLottos(lottoCount);
    }
}
