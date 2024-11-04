package lotto.controller;

import lotto.Lotto;
import lotto.model.LottoResult;
import lotto.service.LottoService;
import lotto.view.LottoView;

import java.util.List;

public class LottoController {
    private final LottoView view;
    private final LottoService service;

    public LottoController(LottoView view, LottoService service) {
        this.view = view;
        this.service = service;
    }

    public void run(){
        int price = view.getPurchasePrice();
        List<Lotto> lottos = service.buyLottos(price);
        view.displayLottos(lottos);

        List<Integer> winningNumbers = view.getWinningNumbers();
        int bonusNumber = view.getBonusNumber();

        LottoResult result = service.evaluateLottos(lottos, winningNumbers, bonusNumber);
        view.displayResult(result);
    }
}
