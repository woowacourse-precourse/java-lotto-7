package lotto;

import lotto.domain.bonus.BonusNumber;
import lotto.domain.lotto.Lotto;
import lotto.domain.winning.WinningContext;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningResult;
import lotto.service.lotto.LottoService;
import lotto.service.lotto.LottoServiceImpl;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoServiceImpl();

        String input = InputView.getAmount();
        lottoService.validateAmount(input);
        int amount = Integer.parseInt(input);

        List<Lotto> lottos = lottoService.generateLottos(amount);
        OutputView.printPurchasedLottos(lottos);

        String winningNumbersInput = InputView.getWinningNumbers();
        String bonusNumberInput = InputView.getBonusNumber();

        WinningNumbers winningNumbers = new WinningNumbers(winningNumbersInput);
        WinningContext context = new WinningContext(winningNumbers, new BonusNumber(bonusNumberInput, winningNumbers.getNumbers()));

        WinningResult result = lottoService.checkResult(lottos, context);

        OutputView.printWinningStatistics(result);
        OutputView.printEarningsRate(lottoService.calculateEarningsRate(result.getTotalPrize(), amount));
    }
}