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
    public static void main(String[] args) {
        LottoApplicationService lottoApplicationService = new LottoApplicationServiceImpl();
        InputHandler inputHandler = new InputHandler();

        // 구입 금액 입력 및 검증
        int amount = inputHandler.getValidatedAmount();

        // 로또 구매 및 출력
        List<Lotto> lottos = lottoApplicationService.generateLottos(amount);
        OutputView.printPurchasedLottos(lottos);

        // 당첨 번호 및 보너스 번호 입력
        WinningNumbers winningNumbers = inputHandler.getValidatedWinningNumbers();
        BonusNumber bonusNumber = inputHandler.getValidatedBonusNumber(winningNumbers);

        // 당첨 결과 계산 및 출력
        WinningContext context = new WinningContext(winningNumbers, bonusNumber);
        WinningResult result = lottoApplicationService.checkResult(lottos, context);
        OutputView.printWinningStatistics(result);
        OutputView.printEarningsRate(lottoApplicationService.calculateEarningsRate(result.getTotalPrize(), amount));
    }
}