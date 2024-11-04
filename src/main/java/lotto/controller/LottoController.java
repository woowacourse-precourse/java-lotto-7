package lotto.controller;

import lotto.domain.BuyingPrice;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
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
        LottoStatisticsService.printStatistics(lottoResults, buyingPrice.getPrice());
    }

}
