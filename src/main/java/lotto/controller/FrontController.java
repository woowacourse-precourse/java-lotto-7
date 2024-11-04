package lotto.controller;

import lotto.repository.LottoRepository;
import lotto.repository.LottoRepositoryImpl;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;

import java.util.List;

import static lotto.view.UserView.*;

public class FrontController {
    private final LottoController lottoController;

    public FrontController() {
        LottoService lottoService = new LottoServiceImpl(LottoRepositoryImpl.getInstance());
        this.lottoController = new LottoController(lottoService);
    }

    public void start() {
        int amount = printAndGetAmount();
        List<Integer> winNumbers = printAndGetWinNumbers();
        int bonusNumber = printAndGetBonusNumber(winNumbers);

        lottoController.addLottoes(amount, winNumbers, bonusNumber);
        lottoController.showLottoes();
        lottoController.showLottoResult(amount, winNumbers, bonusNumber);
    }
}
