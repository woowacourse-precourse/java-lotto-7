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
    private final InputView inputView;
    private final OutputView outputView;
    private final CreateLottoService createLottoService;
    private final LottoStatisticsService statisticsService;
    private final BuyingPriceService buyingPriceService;
    private final WinningCalculateService winningCalculateService;

    public LottoController(
            InputView inputView,
            OutputView outputView,
            CreateLottoService createLottoService,
            LottoStatisticsService statisticsService,
            BuyingPriceService buyingPriceService,
            WinningCalculateService winningCalculateService
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.createLottoService = createLottoService;
        this.statisticsService = statisticsService;
        this.buyingPriceService = buyingPriceService;
        this.winningCalculateService = winningCalculateService;
    }

    public void start() {
        BuyingPrice buyingPrice = processPayment();
        List<Lotto> purchasedLottos = purchaseLottos(buyingPrice);
        WinningLotto winningLotto = getWinningLotto();
        displayResults(purchasedLottos, winningLotto, buyingPrice);
    }

    private BuyingPrice processPayment() {
        outputView.askBuyingPriceView();
        int price = inputView.inputBuyingPriceView();
        return new BuyingPrice(price);
    }

    private List<Lotto> purchaseLottos(BuyingPrice buyingPrice) {
        int numberOfLotto = buyingPriceService.returnNumberOfLotto(buyingPrice);
        outputView.responseBuyingQuantity(numberOfLotto);

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