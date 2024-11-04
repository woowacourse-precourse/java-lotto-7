package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;

import static lotto.view.UserView.*;

import java.util.List;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void addLottoes(int amount, List<Integer> winNumbers, int bonusNumber) {
        lottoService.addLottoes(amount, winNumbers, bonusNumber);
    }

    public void showLottoes() {
        List<Lotto> lottoes = lottoService.getLottoes();
        printRandomNumbersList(lottoes.size(), lottoes);
    }

    public void showLottoResult(int amount, List<Integer> winNumbers, int bonusNumber) {
        Result result = Result.getResult();
        lottoService.getLottoResult(result, winNumbers, bonusNumber);
        printLottoResult(result, amount);
    }
}
