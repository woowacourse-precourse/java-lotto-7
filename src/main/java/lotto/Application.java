package lotto;

import lotto.controller.UserController;

public class Application {

    public static void main(String[] args) {
        final UserController userController = UserController.getInstance();

        userController.getPurchasePrice();
    }
}
