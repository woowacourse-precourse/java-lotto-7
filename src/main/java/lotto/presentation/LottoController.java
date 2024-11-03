package lotto.presentation;

import java.util.List;
import lotto.common.RandomNumberGenerator;
import lotto.domain.LottoResult;
import lotto.presentation.view.InputView;
import lotto.presentation.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RandomNumberGenerator randomNumberGenerator;

    public LottoController(InputView inputView, OutputView outputView,
                           RandomNumberGenerator randomNumberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void run() {
        // 사용자에게 구입 금액 입력 받음
        int purchaseAmount = inputView.getValidPurchaseAmount();

        // 로또 생성
        // IssuedRandomLotto

        // 사용자에게 구입 내역 출력함
        outputView.printPurchase();

        // 사용자에게 당첨번호와 보너스번호 입력받음
        List<Integer> winningNumbers = inputView.getValidWinningNumbers();
        int bonusNumber = inputView.getValidBonusNumber();

        // 당첨번호 생성
        // LottoResult

        // 로또 당첨 결과 계산
        // LottoProfitCalculator

        // 사용자에게 통계 출력함
        outputView.printHitLottoResult();
        outputView.printLottoRateOfProfitResult();
    }
}
