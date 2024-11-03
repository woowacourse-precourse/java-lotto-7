package lotto.controller;

import java.util.List;
import lotto.enums.WinningType;
import lotto.model.Lottos;
import lotto.model.TotalPrice;
import lotto.model.WinningNumbers;
import lotto.model.WinningStatistic;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachineFactory {
    public InputView createInputView() {
        return new InputView();
    }

    public OutputView createOutputView() {
        return new OutputView();
    }

    public Lottos createLottos(int quantity) {
        return Lottos.createLottos(quantity);
    }

    public WinningStatistic createWinningStatistic(WinningNumbers winningNumbers, Lottos lottos) {
        return WinningStatistic.createWinningStatistic(winningNumbers, lottos);
    }

    public TotalPrice createTotalPrice(List<WinningType> winningResults) {
        return TotalPrice.sumAllPrice(winningResults);
    }
}
