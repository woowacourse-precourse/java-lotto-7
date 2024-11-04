package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoNumberPicker;
import lotto.model.LottoPurchase;
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
        int purchaseAmount = inputPurchaseAmount();
        int numberOfLottos = purchaseAmount / 1000;

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

        // 로또 검증 및 결과 계산
        LottoVerification lottoVerification = new LottoVerification(winningNumbers, bonusNumber);
        lottoVerification.calculateRank(purchasedLottos);
        double profitRate = lottoVerification.calculateRateOfReturn(purchaseAmount);

        // 결과 출력
        LottoVerificationView.printResult(lottoVerification.getRankCounts(), profitRate);
    }

    private int inputPurchaseAmount() {
        while (true) {
            try {
                String purchaseAmount = PurchaseLottoView.inputPurchaseAmount();
                LottoPurchase lottoPurchase = new LottoPurchase(purchaseAmount);
                return lottoPurchase.getMoney();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 에러 메시지 출력 후 재입력 요청
            }
        }
    }

    private List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                return WinningLottoInputView.inputWinningLottoNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 에러 메시지 출력 후 재입력 요청
            }
        }
    }

    // 보너스 번호 입력을 받으며 유효하지 않으면 반복 요청
    private int inputBonusNumber() {
        while (true) {
            try {
                return WinningLottoInputView.inputBonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 에러 메시지 출력 후 재입력 요청
            }
        }
    }
}
