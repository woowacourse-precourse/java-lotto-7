package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        LotteryStore store = new LotteryStore();
        List<LottoTicket> tickets = store.purchase();

        Lotto winningLotto = LottoDraw.inputWinningNumbers();
        winningLotto.bonusNumber = LottoDraw.inputBonusNumber(winningLotto);

        LottoResult result = new LottoResult();
        result.calculateResults(tickets, winningLotto, winningLotto.bonusNumber);
        result.displayResults();

    }
}
