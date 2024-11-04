package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.InputController;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static int inputPurchase() {
        System.out.println("구입금액을 입력해 주세요.");
        return InputController.validatePurchase(Integer.parseInt(Console.readLine()));
    }

    public static String inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static int inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
