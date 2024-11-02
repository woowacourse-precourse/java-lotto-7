package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Scanner;

public class InputView {

    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public String enterPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        return Console.readLine();
//        return scanner.nextLine();
    }

    public String enterWinningNumber() {
        System.out.println(WINNING_NUMBER_MESSAGE);
        return Console.readLine();
//        return scanner.nextLine();
    }

    public String enterBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return Console.readLine();
//        return scanner.nextLine();
    }
}
