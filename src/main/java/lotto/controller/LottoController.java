package lotto.controller;

import java.util.Map;
import lotto.repository.InMemoryLottoRepository;
import lotto.repository.LottoRepository;
import lotto.service.BonusNumberManager;
import lotto.service.DecideQuantityOfLotto;
import lotto.service.GenerateLottoNumberManager;
import lotto.service.WininngNumberManager;
import lotto.service.WinningManager;
import lotto.view.OutputView;

public class LottoController {
    OutputView outputView = new OutputView();
    LottoRepository lottoRepository = new InMemoryLottoRepository();

    public void createLottoNumber(int price) {
        int num = new DecideQuantityOfLotto().purchaseLottoTickets(price);
        GenerateLottoNumberManager generate = new GenerateLottoNumberManager(lottoRepository);
        generate.getRandomLottoNumbers();
        outputView.result(generate.getRandomLottoNumbers());
    }

    public void createWinningNumber(String s) {
        WininngNumberManager wininngNumberManager = new WininngNumberManager(s, lottoRepository);
        wininngNumberManager.createWinningNumber();
    }

    public void createBonusNumber(String s) {
        new BonusNumberManager().createBonusNumber(s, lottoRepository);

    }

    public void calculateRate() {
        WinningManager winningManager = new WinningManager();
        Map<String, Integer> resultMap = winningManager.checkWinning(lottoRepository);
        outputView.printresult(resultMap);
        outputView.printRate(winningManager.calculateRate(resultMap, lottoRepository));
    }
}
