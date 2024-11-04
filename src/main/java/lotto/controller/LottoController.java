package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoNumberPicker;
import lotto.model.LottoVerification;
import lotto.view.PurchaseLottoView;
import lotto.view.WinningLottoInputView;
import lotto.view.LottoVerificationView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private final LottoNumberPicker numberPicker = new LottoNumberPicker();

    public void run() {
        // 구입 금액 입력 받기
        int purchaseAmount = PurchaseLottoView.inputPurchaseAmount();
        int numberOfLottos = purchaseAmount / 1000;

        // 로또 번호 생성 (랜덤으로 생성)
        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            purchasedLottos.add(numberPicker.generate());
        }

        // 구매한 로또 번호 출력
        PurchaseLottoView.printPurchasedLottos(purchasedLottos);

        // 당첨 번호 입력
        List<Integer> winningNumbers = WinningLottoInputView.inputWinningLottoNumbers();

        // 보너스 번호 입력
        int bonusNumber = WinningLottoInputView.inputBonusNumber();

        LottoVerification lottoVerification = new LottoVerification(winningNumbers, bonusNumber);

        // 당첨 통계 및 수익률 계산
        lottoVerification.calculateRank(purchasedLottos);
        double profitRate = lottoVerification.calculateRateOfReturn(purchaseAmount);

        // 결과 출력
        LottoVerificationView.printResult(lottoVerification.getRankCounts(), profitRate);
    }

}
