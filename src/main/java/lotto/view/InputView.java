package lotto.view;

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
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static String inputWinningNumber() {
        printInputWinningNumber();
        return readLine();
    }

    private static long parseAmount(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로 입력해 주세요.");
        }
    }

    public static void printRetryMessage() {
        System.out.println("다시 입력해 주세요.");
    }
}
