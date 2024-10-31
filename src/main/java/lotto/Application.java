package lotto;

import lotto.controller.LottoController;
import lotto.controller.UserController;

public class Application {
    private static final int ACCESS_COUNT = 3;

    public static void main(String[] args) {
        final UserController userController = UserController.getInstance();
        final LottoController lottoController = LottoController.getInstance();

        // 구입금액 입력
        int userId = userController.getUserIdByInputPurchasePrice(ACCESS_COUNT);

        // 로또 구매
        lottoController.purchaseLottoTickets(userId);
    }
}
