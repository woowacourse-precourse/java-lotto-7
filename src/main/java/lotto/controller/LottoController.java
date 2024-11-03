package lotto.controller;

import java.util.Map;
import lotto.repository.InMemoryLottoRepository;
import lotto.repository.LottoRepository;
import lotto.service.BonusNumberManager;
import lotto.service.LottoTicketService;
import lotto.service.WininngNumberManager;
import lotto.service.WinningManager;
import lotto.view.OutputView;

public class LottoController {
    OutputView outputView = new OutputView();
    LottoRepository lottoRepository = new InMemoryLottoRepository();

    public void createLottoNumber(int price) {
        LottoTicketService lottoTicketService = new LottoTicketService();
        int numberOfLotto = lottoTicketService.purchaseLottoTickets(price);
        lottoTicketService.generateLottoNumbers(numberOfLotto, lottoRepository);
        outputView.result(lottoTicketService.getRandomLottoNumbers(lottoRepository));
    }

    public void createWinningNumber(String s) {
        WininngNumberManager wininngNumberManager = new WininngNumberManager(s, lottoRepository);
        wininngNumberManager.createWinningNumber();
    }

    public void createBonusNumber(int bonusNumber) {
        new BonusNumberManager().createBonusNumber(bonusNumber, lottoRepository);

    }

    public void calculateRate() {
        WinningManager winningManager = new WinningManager();
        Map<String, Integer> resultMap = winningManager.checkWinning(lottoRepository);
        outputView.printresult(resultMap);
        outputView.printRate(winningManager.calculateRate(resultMap, lottoRepository));
    }
}
