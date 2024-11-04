package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.UserRequestController;

import static lotto.view.UserResponseView.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        UserRequestController userRequestController = new UserRequestController();

        startMessage();
        String money = Console.readLine();
        System.out.println();

        userRequestController.inputMoney(money);
        winLottoMessage();
        String winNumbers = Console.readLine();
        System.out.println();

        userRequestController.inputWinNumbers(winNumbers);
        bonusLottoMessage();
        String bonusNum = Console.readLine();
        System.out.println();

        userRequestController.inputBonusNum(bonusNum);

    }
}
