package lotto.controller;

import lotto.domain.LottoResult;
import lotto.domain.user.User;
import lotto.service.UserService;
import lotto.service.UserWinningResultService;

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

    public User getUserIdByInputPurchasePrice() {
        return userService.inputPurchasePriceForUser();
    }

    public void getPurchaseLottoTickets(User user) {
        userService.getLottoTickets(user);
        userService.displayPurchaseLottoTickets(user);
    }

    public void getWinningResult(LottoResult lottoResult, User user) {
        userWinningResultService.getWinningResult(lottoResult, user);
    }
}
