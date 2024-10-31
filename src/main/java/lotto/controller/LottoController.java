package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import static lotto.view.UserView.*;

import java.util.List;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void start(int amount, List<Integer> winNumbers, int bonusNumber) {
        lottoService.play(amount, winNumbers, bonusNumber);
        printLottoList();

//        lottoService.showResult();
    }

    private void printLottoList() {
        List<Lotto> lottoList = lottoService.showLottoList();
        printRandomNumbersList(lottoList.size(), lottoList);
    }
}
