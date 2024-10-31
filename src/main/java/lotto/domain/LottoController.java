package lotto.domain;

import lotto.view.InputView;

public class LottoController {
    public void start() {
        UserMoney userMoney = getUserMoney();
    }

    private UserMoney getUserMoney() {
        while(true) {
            try {
                String userInput = InputView.readUserMoney();
                return new UserMoney(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
