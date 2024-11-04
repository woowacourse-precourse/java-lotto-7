package lotto.application;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoService implements Service {

    private Lottoes lottoes;
    private PriceToBuyLotto priceToBuyLotto;

    public LottoService() {
    }

    @Override
    public void buyLottoHandler() {
        //input
        OutputView.printPromptMessageForPriceToBuyLotto();
        PriceToBuyLotto priceToBuyLotto = InputView.getPriceToBuyLotto();
        this.priceToBuyLotto = priceToBuyLotto;

        //generate Lotto
        Lottoes lottoes = new Lottoes(priceToBuyLotto);
        this.lottoes = lottoes;

        //output
        lottoes.printLottoesInfo();
    }

    @Override
    public void matchLottoHandler() {
        //input WinningLottoNumber
        OutputView.printPromptMessageForWinningLotto();
        WinningLottoNumber winningLottoNumber = InputView.getWinningLottoNumber();

        //input BonusNumber
        OutputView.printPromptMessageForBonusNumber();
        BonusNumber bonusNumber = InputView.getBonusNumber(winningLottoNumber);

        //make winning Lotto object
        WinningLotto winningLotto = WinningLotto.of(winningLottoNumber, bonusNumber);

        //lotto match
        LottoMatcher lottoMatcher = new LottoMatcher(winningLotto);
        lottoMatcher.startMatch(lottoes);

        //output
        OutputView.printPromptMessageForWinningResult();
        lottoMatcher.printWinningResult();
        lottoMatcher.printRateOfWinningResult(priceToBuyLotto);
    }

}