package lotto.controller;

import lotto.view.InputView;
import lotto.domain.LottoDrawer;
import lotto.domain.LottoMachine;
import lotto.domain.LottoStore;
import lotto.view.OutputView;
import lotto.domain.PrizeResult;

public class LottoController {

    public void start(){
        InputView inputView = new InputView();
        OutputView outputView =new OutputView();
        PrizeResult prizeResult = new PrizeResult();
        LottoStore lottoStore = new LottoStore(inputView);
        LottoMachine lottoMachine = new LottoMachine(lottoStore.getTickets());
        outputView.printLottoNumbers(lottoMachine.getLottoNumbers());
        LottoDrawer lottoDrawer = new LottoDrawer(lottoMachine, lottoStore.getLottoNumbers(),lottoStore.getBonusNumber());
        lottoDrawer.getWinningCount();
        outputView.printPrizeResults();
        outputView.printRateOfReturn(prizeResult.getRateOfReturn(lottoStore.getMoney()));
    }

}
