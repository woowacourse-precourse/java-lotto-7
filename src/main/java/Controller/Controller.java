package Controller;

import Model.Lotto;
import Model.LottoCheck;
import View.InputView;
import View.OutputView;
import Util.Validator;

import java.util.List;

public class Controller {
    public void run() {
        // Step 1: 구입 금액 입력 및 유효성 검사
        Integer purchaseAmount = null;
        while (purchaseAmount == null) {
            purchaseAmount = InputView.getPurchaseAmount();
        }

        // Step 2: 로또 생성 및 출력
        List<Lotto> lottos = InputView.generateLottos();
        OutputView.printTrialLottoCount(InputView.trialLottoCount);
        OutputView.printLottosNumbers(lottos);

        // Step 3: 당첨 번호 입력 및 유효성 검사
        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        Integer bonusNumber = null;
        while (bonusNumber == null) {
            bonusNumber = InputView.inputBonusNumber();
        }

        // Step 4: 당첨 검사 및 결과 출력
        LottoCheck lottoCheck = new LottoCheck(lottos, winningNumbers, bonusNumber);
        OutputView.printCheckStart();
        lottoCheck.checkWinningCounts();
    }
}
