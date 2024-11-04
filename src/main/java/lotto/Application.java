package lotto;

import lotto.domain.model.bonus.BonusNumber;
import lotto.domain.model.lotto.Lotto;
import lotto.domain.model.winning.WinningContext;
import lotto.domain.model.winning.WinningNumbers;
import lotto.domain.model.winning.WinningResult;
import lotto.service.LottoApplicationService;
import lotto.service.LottoApplicationServiceImpl;
import lotto.view.input.InputHandler;
import lotto.view.output.OutputView;

import java.util.List;

public class Application {
    private final LottoApplicationService lottoService = new LottoApplicationServiceImpl();
    private final InputHandler inputHandler = new InputHandler(lottoService);

    public static void main(String[] args) {
        new Application().run();
    }
    private void run() {
        int amount = getValidatedAmount();
        WinningContext context = getWinningContext();
        WinningResult result = lottoService.result(generateAndPrintLottos(amount), context);
        OutputView.printWinningStatistics(result);
        OutputView.printEarningsRate(lottoService.calculateEarningsRate(result.getTotalPrize(), amount));
    }
    private int getValidatedAmount() {
        return inputHandler.getValidatedAmount();
    }
    private List<Lotto> generateAndPrintLottos(int amount) {
        List<Lotto> lottos = lottoService.generateLottos(amount);
        OutputView.printPurchasedLottos(lottos);
        return lottos;
    }
    private WinningContext getWinningContext() {
        WinningNumbers winningNumbers = inputHandler.getValidatedWinningNumbers();
        BonusNumber bonusNumber = inputHandler.getValidatedBonusNumber(winningNumbers);
        return new WinningContext(winningNumbers, bonusNumber);
    }
}