package lotto;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = InputValidator.readPurchaseAmount();
        List<Lotto> userLottos = LottoGenerator.generateLottos(purchaseAmount);
        OutputView.printLottoTickets(userLottos);

        List<Integer> winningNumbers = InputValidator.readWinningNumbers();
        int bonusNumber = InputValidator.readBonusNumber(winningNumbers);

        Map<Rank, Integer> results = LottoResult.calculateResults(userLottos, winningNumbers, bonusNumber);
        OutputView.printResults(results, purchaseAmount);
    }
}