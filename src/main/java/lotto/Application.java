package lotto;

import lotto.domain.InputView;
import lotto.domain.LottoController;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        LottoController lottoController = new LottoController();

        int purchaseMoney = inputView.getPurchaseMoney();
        lottoController.createLotto(purchaseMoney);

        List<Integer> winningNumbers = inputView.getWinningNumber();
        int bonusNumber = inputView.getBonusNumber();

        lottoController.lottoResult(winningNumbers, bonusNumber);
        System.out.println("총 수익률은 "+lottoController.profitRate(purchaseMoney)+"%입니다.");

    }
}
