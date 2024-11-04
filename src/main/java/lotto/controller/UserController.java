package lotto.controller;

import lotto.domain.LottoResult;
import lotto.service.UserService;
import lotto.service.UserWinningResultService;
import lotto.view.ErrorOutputView;

public class UserController {
    // 싱글톤 패턴
    private static final UserController instance = new UserController();
    private final UserService userService = UserService.getInstance();
    private final UserWinningResultService userWinningResultService = UserWinningResultService.getInstance();

    private UserController() {
    }

    public static UserController getInstance() {
        return instance;
    }

    public int getUserIdByInputPurchasePrice() {
        while(true) {
            try {
                return userService.inputPurchasePriceForUser();
            } catch (IllegalArgumentException e) {
                ErrorOutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public void getPurchaseLottoTickets(int userId) {
        userService.getLottoTickets(userId);
        userService.displayPurchaseLottoTickets(userId);
    }

    public void getWinningResult(LottoResult lottoResult, int userId) {
        userWinningResultService.getWinningResult(lottoResult, userId);
    }
}
