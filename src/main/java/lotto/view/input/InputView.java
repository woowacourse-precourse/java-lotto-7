package lotto.view.input;

import lotto.common.ViewConstants;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getAmount() {
        System.out.println(ViewConstants.INPUT_PURCHASE_AMOUNT);
        return scanner.nextLine();
    }

    public static String getWinningNumbers() {
        System.out.println(ViewConstants.INPUT_WINNING_NUMBERS);
        return scanner.nextLine();
    }

    public static String getBonusNumber() {
        System.out.println(ViewConstants.INPUT_BONUS_NUMBER);
        return scanner.nextLine();
    }
}
