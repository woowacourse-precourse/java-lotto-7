package lotto;

import lotto.controller.UserController;

public class Application {
    private static final int ACCESS_COUNT = 3;

    public static void main(String[] args) {
        final UserController userController = UserController.getInstance();

        userController.getPurchasePrice(ACCESS_COUNT);
    }
}
