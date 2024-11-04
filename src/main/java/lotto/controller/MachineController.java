package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class MachineController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;

    public MachineController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoMachine = new LottoMachine();
    }

    public void startLotto() {
        List<Lotto> lottos = purchaseLotto();
        Map<Integer, Integer> resultMap = drawLotto(lottos);
        printResult(lottos, resultMap);
    }

    private List<Lotto> purchaseLotto() {
        int amount = inputView.getAmount();
        List<Lotto> lottos = lottoMachine.generateLotto(amount);
        outputView.printLottos(lottos);
        return lottos;
    }

    private Map<Integer, Integer> drawLotto(List<Lotto> lottos) {
        List<Integer> winningNumber = inputView.getWinningNumber();
        int bonusNumber = inputView.getBonusNumber(winningNumber);
        return lottoMachine.calculateStats(lottos, winningNumber, bonusNumber);
    }

    private void printResult(List<Lotto> lottos, Map<Integer, Integer> resultMap) {
        outputView.printStats(resultMap);
        outputView.printProfit(lottos, resultMap);
    }

}
