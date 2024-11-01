package lotto;

import lotto.collection.WinningNumbers;
import lotto.controller.LottoController;
import lotto.controller.UserController;
import lotto.domain.LottoResult;

public class Application {
    public static void main(String[] args) {
        final UserController userController = UserController.getInstance();
        final LottoController lottoController = LottoController.getInstance();

        // 구입금액 입력
        int userId = userController.getUserIdByInputPurchasePrice();

        // 로또 구매
        userController.getPurchaseLottoTickets(userId);

        // 당첨 번호 입력
        WinningNumbers winningNumbers = lottoController.getWinningNumbers();

        // 보너스 번호 입력
        LottoResult lottoResult = lottoController.getBonusNumbers(winningNumbers);


    }
}
