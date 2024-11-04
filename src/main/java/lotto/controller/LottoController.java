package lotto.controller;

import java.util.Map;
import lotto.repository.InMemoryLottoRepository;
import lotto.repository.LottoRepository;
import lotto.service.LottoDrawService;
import lotto.service.LottoTicketService;
import lotto.service.WininngNumberManager;
import lotto.view.OutputView;

public class LottoController {
    OutputView outputView = new OutputView();
    LottoRepository lottoRepository = new InMemoryLottoRepository();
    private int numberOfLotto;


    public void createLottoNumber(int price) {
        LottoTicketService lottoTicketService = new LottoTicketService();
        numberOfLotto = lottoTicketService.purchaseLottoTickets(price);
        lottoTicketService.generateLottoNumbers(numberOfLotto, lottoRepository);
        outputView.printRandomNumber(lottoTicketService.getLottoNumbers(lottoRepository));
    }

    public void createWinningNumber(String[] inputWinningNumber) {
        new WininngNumberManager().createWinningNumber(inputWinningNumber, lottoRepository);
    }

    public void createBonusNumber(int bonusNumber) {
        new WininngNumberManager().createBonusNumber(bonusNumber, lottoRepository);
    }

    public void calculateRate() {
        LottoDrawService lottoDrawService = new LottoDrawService();
        Map<String, Integer> resultMap = lottoDrawService.checkWinning(lottoRepository);
        outputView.printResult(resultMap);
        outputView.printRate(lottoDrawService.calculateRate(resultMap, numberOfLotto));
    }
}
