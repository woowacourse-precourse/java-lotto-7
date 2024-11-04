package lotto;

import java.util.List;
import lotto.controller.LottoController;
import lotto.domain.DrawNumbers;
import lotto.domain.Purchase;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();

        Purchase purchase = lottoController.purchaseLotto();
        List<DrawNumbers> randomDrawNumbers = lottoController.drawPurchaseLotto(purchase);
        DrawNumbers winningNumbers = lottoController.drawWinningLotto();

        lottoController.showDraw(randomDrawNumbers, winningNumbers, purchase);
    }
}
