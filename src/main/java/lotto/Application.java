package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.UserRequestController;

import static lotto.view.UserResponseView.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        UserRequestController userRequestController = new UserRequestController();

        userRequestController.inputMoney();
        System.out.println();

        userRequestController.inputWinNumbers();
        System.out.println();

        userRequestController.inputBonusNum();
        System.out.println();



    }
}
