package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = inputPurchaseAmount();
        //System.out.println("Purchased: " + purchaseAmount);
    }

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int purchaseAmount = parsePurchaseAmount(input);
        return purchaseAmount;
    }

    public static int parsePurchaseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(ERROR_MESSAGE + " 구입금액은 정수형이어야 합니다 : " + input);
            return -1;
        }
    }
}
