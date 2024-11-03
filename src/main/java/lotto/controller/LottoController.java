package lotto.controller;

import lotto.dto.Purchase;
import lotto.model.MyLotto;
import lotto.model.Winning;
import lotto.service.InputService;
import lotto.service.LottoService;

public class LottoController {
    public void play() {
        InputService inputService = new InputService();
        LottoService lottoService = new LottoService();

        Purchase purchase = new Purchase(inputService.getPurchaseMoney());
        Winning winning = new Winning(inputService.getWinningNumbers(), inputService.getBonusNumber());
        MyLotto myLotto = lottoService.buyLottos(purchase);
    }
}
