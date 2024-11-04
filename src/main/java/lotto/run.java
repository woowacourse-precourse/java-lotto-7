package lotto;

import lotto.core.LottoGenerator;
import lotto.inputview.BonusNumberInputView;
import lotto.inputview.LottoNumbersInputView;
import lotto.inputview.PurchaseAmountInputView;
import lotto.outputview.LottoNumbersOutputView;

import java.util.ArrayList;
import java.util.List;

public class run {
    public static void run() {
        // 1. 구매 금액 입력 및 로또 개수 계산
        int numberOfLottos = PurchaseAmountInputView.inputPurchaseAmount();

        // 2. 로또 번호 생성
        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> lottoNumbers = LottoGenerator.generate();
            purchasedLottos.add(new Lotto(lottoNumbers));
        }

        // 3. 로또 번호 출력
        LottoNumbersOutputView.printPurchasedLottos(numberOfLottos, purchasedLottos);
        // 4. 당첨 번호 입력
        Lotto winningLotto = LottoNumbersInputView.inputLottoNumbers();

        // 5. 보너스 번호 입력
        int bonusNumber = BonusNumberInputView.inputBonusNumber();

        // 6. 추가 로직: 당첨 번호와 구매한 로또 번호 비교 (예시: 출력)
        //LottoNumbersOutputView.printResult(purchasedLottos, winningLotto, bonusNumber);
    }
}
