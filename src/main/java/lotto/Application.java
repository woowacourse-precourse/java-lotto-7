package lotto;

import lotto.controller.LottoController;
import lotto.controller.UserController;

public class Application {
    public static void main(String[] args) {
        final UserController userController = UserController.getInstance();
        final LottoController lottoController = LottoController.getInstance();

        // 구입금액 입력
        int userId = userController.getUserIdByInputPurchasePrice();

        // 로또 구매
        lottoController.purchaseLottoTickets(userId);
    }
}
