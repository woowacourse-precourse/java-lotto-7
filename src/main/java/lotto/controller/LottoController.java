package lotto.controller;

import java.util.List;
import lotto.view.InputView;
import lotto.domain.LottoDrawer;
import lotto.domain.LottoMachine;
import lotto.domain.LottoStore;
import lotto.view.OutputView;
import lotto.domain.PrizeResult;

public class LottoController {

    private final InputView inputView = new InputView();
    LottoStore lottoStore = new LottoStore(inputView.inputMoney());


    public void start(){
        OutputView outputView =new OutputView();
        PrizeResult prizeResult = new PrizeResult();
        LottoMachine lottoMachine = new LottoMachine(lottoStore.getTickets());
        outputView.printLottoNumbers(lottoMachine.getLottoNumbers());
        LottoDrawer lottoDrawer = new LottoDrawer(lottoMachine, winningNumber(),bonusNumber());
        lottoDrawer.getWinningCount();
        outputView.printPrizeResults();
        outputView.printRateOfReturn(prizeResult.getRateOfReturn(lottoStore.getMoney()));
    }

    private List<Integer> winningNumber() {
        while (true) {
            try {
                return lottoStore.getLottoNumbers(inputView.inputWinningNumber());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private int bonusNumber() {
        while (true) {
            try {
                return lottoStore.getBonusNumber(inputView.inputBonusNumber());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

}
