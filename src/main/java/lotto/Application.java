package lotto;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResult;
import lotto.domain.Rank;
import lotto.view.InputValidator;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = InputValidator.readPurchaseAmount();
        List<Lotto> userLottos = LottoGenerator.generateLottos(purchaseAmount);
        OutputView.printLottoTickets(userLottos);

        List<Integer> winningNumbers = InputValidator.readWinningNumbers();
        int bonusNumber = InputValidator.readBonusNumber(winningNumbers);

        Map<Rank, Integer> results = LottoResult.calculateResults(userLottos, winningNumbers, bonusNumber);
        OutputView.printResults(results, purchaseAmount);
    }
}
