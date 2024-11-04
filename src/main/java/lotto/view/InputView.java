package lotto.view;

import lotto.model.BonusNumber;
import lotto.model.Money;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static void printInputPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public static Money inputPurchaseAmount() {
        printInputPurchaseAmount();
        long amount = parseAmount(readLine());
        return new Money(amount);
    }

    public static void printInputWinningNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public static String inputWinningNumber() {
        printInputWinningNumber();
        return readLine();
    }

    public static void printInputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public static BonusNumber inputBonusNumber() {
        printInputBonusNumber();
        return new BonusNumber(parseBonusNumber(readLine()));

    }

    public static void errorPrint(String message) {
        System.out.println(message);
        printRetryMessage();
    }

    private static void printRetryMessage() {
        System.out.println("다시 입력해 주세요.\n");
    }

    private static long parseAmount(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로 입력해 주세요.");
        }
    }

    private static int parseBonusNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자로만 입력해 주세요.");
        }

    }
}
