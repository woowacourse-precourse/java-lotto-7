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
        int purchaseAmount;
        while (true) {
            try {
                purchaseAmount = lottoPurchase.purchaseAmount();
                break;

            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 금액은 숫자를 입력해주세요");
            }
        }

        List<Lotto> issuedLotto = lottoPurchase.issueLotto(purchaseAmount);

        List<Integer> winningNumbers;
        while (true) {
            try {
                winningNumbers = lottoWinningNumber.input();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 1~45까지의 정수 6개를 입력해주세요. ex) 1,2,3,4,5,6");
            }
        }

        int bonusNumber;
        while (true) {
            try {
                bonusNumber = lottoBonusNumber.input(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 1~45까지의 정수를 입력해주세요.");
            }
        }

        lottoProfitCalculator.checkLotto(issuedLotto, winningNumbers, bonusNumber);
    }
}
