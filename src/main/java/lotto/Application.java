package lotto;

import lotto.domain.bonus.BonusNumber;
import lotto.domain.lotto.Lotto;
import lotto.domain.winning.WinningContext;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningResult;
import lotto.service.lotto.LottoService;
import lotto.service.lotto.LottoServiceImpl;
import lotto.view.input.InputHandler;
import lotto.view.output.OutputView;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoServiceImpl();
        InputHandler inputHandler = new InputHandler();

        // 구입 금액 입력 및 검증
        int amount = inputHandler.getValidatedAmount();

        // 로또 구매 및 출력
        List<Lotto> lottos = lottoService.generateLottos(amount);
        OutputView.printPurchasedLottos(lottos);

        // 당첨 번호 및 보너스 번호 입력
        WinningNumbers winningNumbers = inputHandler.getValidatedWinningNumbers();
        BonusNumber bonusNumber = inputHandler.getValidatedBonusNumber(winningNumbers);

        // 당첨 결과 계산 및 출력
        WinningContext context = new WinningContext(winningNumbers, bonusNumber);
        WinningResult result = lottoService.checkResult(lottos, context);
        OutputView.printWinningStatistics(result);
        OutputView.printEarningsRate(lottoService.calculateEarningsRate(result.getTotalPrize(), amount));
    }
}