package lotto.controller;

import lotto.service.UserService;

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
        int purchasePrice = userService.getPurchasePrice(accessCount);
        userService.save(purchasePrice);
    }
}
