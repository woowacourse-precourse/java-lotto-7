package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.ViewConstants;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getAmount() {
        System.out.println(ViewConstants.INPUT_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public static String getWinningNumbers() {
        System.out.println(ViewConstants.INPUT_WINNING_NUMBERS);
        return Console.readLine();
    }

    public static String getBonusNumber() {
        System.out.println(ViewConstants.INPUT_BONUS_NUMBER);
        return Console.readLine();
    }
}
