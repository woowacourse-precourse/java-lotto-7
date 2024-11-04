package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoStatistics;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int amount = getInputLottoAmount();
        List<Lotto> lottos = generateLottos(amount / 1000);
        printLottoDetails(lottos);
        WinningNumbers winningNumbers = getWinningNumbers(); // 당첨 결과 및 수익률 계산
        LottoStatistics statistics = new LottoStatistics(lottos, winningNumbers);
        outputView.printStatistics(statistics.getResult());
        outputView.printProfitRate(statistics.getProfitRate());
    }

    private int getInputLottoAmount() {
        outputView.printInputMoney();
        return inputView.inputLottoAmount();
    }

    private List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.generateRandomLotto());
        }
        return lottos;
    }

    private void printLottoDetails(List<Lotto> lottos) {
        outputView.printLottoAmount(lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    private WinningNumbers getWinningNumbers() {
        outputView.printWinningNumbers();
        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        outputView.printBonusNumber();
        int bonusNumber = InputView.inputBonusNumber();
        return new WinningNumbers(winningNumbers, bonusNumber);
    }
}