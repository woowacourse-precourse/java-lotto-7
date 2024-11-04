package lotto;

import java.util.List;
import lotto.domain.LottoTickets;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private final InputView inputView;

    public LottoGame(InputView inputView) {
        this.inputView = inputView;
    }

    public void play() {
        int purchaseAmount = inputView.inputPurchaseAmount();

        LottoTickets lottoTickets = new LottoTickets(purchaseAmount);
        OutputView outputView = new OutputView(lottoTickets);

        outputView.showLottoTickets(purchaseAmount);

        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber(winningNumbers);
        outputView.showResult(winningNumbers, bonusNumber, purchaseAmount);
    }
}
