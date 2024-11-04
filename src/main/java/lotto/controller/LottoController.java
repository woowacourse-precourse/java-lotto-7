package lotto.controller;

import lotto.domain.BuyingPrice;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.service.BuyingPriceService;
import lotto.service.CreateLottoService;
import lotto.service.WinningCalculateService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();


    public void start() {
        outputView.askBuyingPriceView();
        BuyingPrice buyingPrice = new BuyingPrice(inputView.inputBuyingPriceView());
        int lottoNum = BuyingPriceService.returnNumberOfLotto(buyingPrice);
        outputView.responseBuyingQuantity(lottoNum);
        List<Lotto> lottos = CreateLottoService.createRandomLotto(lottoNum);
        outputView.askWinningLotto();
        WinningLotto winningLotto = new WinningLotto(inputView.inputLottoNumbersView());
        outputView.askBonusNumber();
        int bonusNum = inputView.inputBonusNumberView();
        LottoResult lottoResult = new LottoResult(WinningCalculateService.calculateLottoResult(lotto, winningLotto));






        calculateResults(lottos, winningLotto);
    }

    public Lotto setLottoData() {
        return lottoInputDataService.inputLottoData();
    }

    public void calculateLottoWinning(User user, Lotto lotto) {
        lottoCalculateService.calculateWinning(user, lotto);
    }

}
