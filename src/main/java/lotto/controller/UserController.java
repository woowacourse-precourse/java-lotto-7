package lotto.controller;

import lotto.service.UserService;
import lotto.view.ErrorOutputView;

public class UserController {
    // 싱글톤 패턴
    private static final UserController instance = new UserController();
    private final UserService userService = UserService.getInstance();

    private UserController() {
    }

    public static UserController getInstance() {
        return instance;
    }

    public void getPurchasePrice(int accessCount) {
        int count = accessCount;
        while (count > 0) {
            try {
                int purchasePrice = userService.inputPurchasePrice();
                userService.save(purchasePrice);
                return;

            } catch (IllegalArgumentException e) {
                ErrorOutputView.printErrorMessage(e.getMessage());
                count--;
            }
        }
        if (count == 0) {
            userService.exit(accessCount);
        }
    }
}
