package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;

public class LottoController {
    private final LottoPurchase lottoPurchase;
    private final LottoWinningNumber lottoWinningNumber;
    private final LottoBonusNumber lottoBonusNumber;
    private final LottoProfitCalculator lottoProfitCalculator;

    public LottoController(
            LottoPurchase lottoPurchase,
            LottoWinningNumber lottoWinningNumber,
            LottoBonusNumber lottoBonusNumber,
            LottoProfitCalculator lottoProfitCalculator
    ) {
        this.lottoPurchase = lottoPurchase;
        this.lottoWinningNumber = lottoWinningNumber;
        this.lottoBonusNumber = lottoBonusNumber;
        this.lottoProfitCalculator = lottoProfitCalculator;
    }


    public void run() {
        // Step 1: 로또 구입 금액 입력
        int purchaseAmount;
        while (true) {
            try {
                purchaseAmount = lottoPurchase.purchaseAmount();
                break; // 올바른 값이 입력되면 루프 종료

            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 금액은 숫자를 입력해주세요");
            }
        }
        // Step 2: 개수에 맞게 로또 발행
        List<Lotto> issuedLotto = lottoPurchase.issueLotto(purchaseAmount);

        // Step 3: 로또 당첨번호 입력
        List<Lotto> winningNumbers;
        while (true) {
            try {
                winningNumbers = lottoWinningNumber.input();
                break; // 올바른 값이 입력되면 루프 종료
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 1~45까지의 정수 6개를 입력해주세요. ex) 1,2,3,4,5,6");
            }
        }

        // Step 4: 보너스 번호 입력
        int bonusNumber;
        while (true) {
            try {
        bonusNumber = lottoBonusNumber.input(winningNumbers);
                break; // 올바른 값이 입력되면 루프 종료
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 1~45까지의 정수를 입력해주세요.");
            }
        }

        // Step 5: 수익률 출력
        lottoProfitCalculator.checkLotto(issuedLotto, winningNumbers, bonusNumber);
    }
}
