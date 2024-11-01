package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;


    public LottoController(InputView inputView) {
        this.inputView = inputView;

    }

    public void run() {

        int numberOfPurchasedLotto = inputView.inputPrice() / 1000;

        List<Lotto> generatedLottos = LottoService.generateLotto(numberOfPurchasedLotto);


    }
}
