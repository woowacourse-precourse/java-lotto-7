package lotto.view;

import lotto.LottoMatchState;
import lotto.model.Lottos;

import java.util.Map;

public class ViewFacade {
    private final InputView inputView;
    private final OutputView outputView;

    public ViewFacade(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public String readPurchaseAmount() {
        return inputView.readPurchaseAmount();
    }

    public String readWinningNums() {
        return inputView.readWinningNums();
    }

    public String readBonusNum() {
        return inputView.readBonusNum();
    }

    public void printIssuedLottos(Lottos lottos) {
        outputView.printIssuedLottos(lottos);
    }

    public void printWinningDetail(Map<LottoMatchState, Integer> winningDetail) {
        outputView.printWinningDetail(winningDetail);
    }

    public void printProfitRate(double profitRate) {
        outputView.printProfitRate(profitRate);
    }
}
