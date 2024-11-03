package lotto.controller;
import java.util.List;
import lotto.Lotto;

public class LottoController {
    private final LottoPurchase lottoPurchase;
    private final LottoIssuer lottoIssuer;
    private final LottoWinningNumber lottoWinningNumber;
    private final LottoBonusNumber lottoBonusNumber;
    private final LottoProfitCalculator lottoProfitCalculator;

    public LottoController(
            LottoPurchase lottoPurchase,
            LottoIssuer lottoIssuer,
            LottoWinningNumber lottoWinningNumber,
            LottoBonusNumber lottoBonusNumber,
            LottoProfitCalculator lottoProfitCalculator
    ) {
        this.lottoPurchase = lottoPurchase;
        this.lottoIssuer = lottoIssuer;
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
        System.out.println(purchaseAmount);
        // Step 2: 개수에 맞게 로또 발행
        List<Lotto> issuedLotto = lottoIssuer.issueLotto(purchaseAmount);

        // Step 3: 로또 당첨번호 입력
        List<Integer> winningNumbers = lottoWinningNumber.winningNumber();

        // Step 4: 보너스 번호 입력
        int bonusNumber = lottoBonusNumber.inputBonusNumber();

        // Step 5: 수익률 출력
        double profit = lottoProfitCalculator.calculateProfit(issuedLotto, winningNumbers, bonusNumber);
        System.out.println("수익률: " + profit + "%");
    }
}
