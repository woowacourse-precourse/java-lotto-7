package lotto.controller;

import lotto.domain.*;
import lotto.service.BuyingPriceService;
import lotto.service.CreateLottoService;
import lotto.service.LottoStatisticsService;
import lotto.service.WinningCalculateService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final CreateLottoService createLottoService = new CreateLottoService();
    private final LottoStatisticsService statisticsService = new LottoStatisticsService();
    private final BuyingPriceService buyingPriceService = new BuyingPriceService();
    private final WinningCalculateService winningCalculateService = new WinningCalculateService();


    public void start() {
        BuyingPrice buyingPrice = lottoPayment();
        List<Lotto> purchasedLottos = publishLottos(buyingPrice);
        WinningLotto winningLotto = getWinningLotto();
        displayResults(purchasedLottos, winningLotto, buyingPrice);
    }

    private BuyingPrice lottoPayment() {
        outputView.askBuyingPriceView();
        String buyingPrice = inputView.inputBuyingPriceView();
        return new BuyingPrice(buyingPrice);
    }

    private List<Lotto> publishLottos(BuyingPrice buyingPrice) {
        int numberOfLotto = buyingPriceService.returnNumberOfLotto(buyingPrice);
        outputView.responseNumberOfLotto(numberOfLotto);

        List<Lotto> lottos = createLottoService.createRandomLottos(numberOfLotto);
        outputView.printLottos(lottos);

        return lottos;
    }

    private WinningLotto getWinningLotto() {
        outputView.askWinningLotto();
        String winningNumbers = inputView.inputLottoNumbersView();

        outputView.askBonusNumber();
        String bonusNumber = inputView.inputBonusNumberView();

        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private void displayResults(List<Lotto> purchasedLottos, WinningLotto winningLotto, BuyingPrice buyingPrice) {
        List<LottoResult> lottoResults = winningCalculateService.calculateLottoResults(purchasedLottos, winningLotto);
        LottoStatistics statistics = statisticsService.calculateStatistics(lottoResults, buyingPrice.getPrice());
        outputView.printStatistics(statistics);
    }
}