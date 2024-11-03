package lotto.view;

import lotto.model.Lottos;
import lotto.model.WinningStatistic;

public class ViewFacade {
    private final InputView inputView;
    private final OutputView outputView;

    public ViewFacade(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public String getCost() {
        return inputView.getCost();
    }

    public String getWinningNumbers() {
        return inputView.getWinningNumbers();
    }

    public String getBonusNumber() {
        return inputView.getBonusNumber();
    }

    public void showLottos(int count, Lottos lottos) {
        outputView.showLottos(count, lottos);
    }

    public void showWinningStatistics(WinningStatistic winningStatistic) {
        outputView.showWinningStatistics(winningStatistic);
    }


}