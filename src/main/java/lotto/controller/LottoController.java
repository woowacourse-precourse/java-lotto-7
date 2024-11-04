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


    public void start() {
        outputView.askBuyingPriceView();
        int price = inputView.inputBuyingPriceView();
        BuyingPrice buyingPrice = new BuyingPrice(price);
        int lottoNum = BuyingPriceService.returnNumberOfLotto(buyingPrice);
        outputView.responseBuyingQuantity(lottoNum);
        List<Lotto> lottos = createLottoService.createRandomLottos(lottoNum);
        outputView.printLottos(lottos);
        outputView.askWinningLotto();
        String winningLottoNumber = inputView.inputLottoNumbersView();
        outputView.askBonusNumber();
        String bonusNumber = inputView.inputBonusNumberView();
        WinningLotto winningLotto = new WinningLotto(winningLottoNumber, bonusNumber);
        List<LottoResult> lottoResults = WinningCalculateService.calculateLottoResults(lottos, winningLotto);
        LottoStatistics lottoStatistics = statisticsService.calculateStatistics(lottoResults, buyingPrice.getPrice());
        outputView.printStatistics(lottoStatistics);
    }

}
