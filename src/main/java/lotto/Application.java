package lotto;
import lotto.controller.LottoBonusNumber;
import lotto.controller.LottoController;
import lotto.controller.LottoProfitCalculator;
import lotto.controller.LottoPurchase;
import lotto.controller.LottoWinningNumber;

public class Application {
    public static void main(String[] args) {
        LottoPurchase lottoPurchase = new LottoPurchase();
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber();
        LottoBonusNumber lottoBonusNumber = new LottoBonusNumber();
        LottoProfitCalculator lottoProfitCalculator = new LottoProfitCalculator();

        LottoController controller = new LottoController(
                lottoPurchase,
                lottoWinningNumber,
                lottoBonusNumber,
                lottoProfitCalculator
        );

        controller.run();
    }
}
