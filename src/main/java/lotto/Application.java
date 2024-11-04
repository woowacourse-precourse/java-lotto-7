package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String error_message = "[ERROR]";

    public static void main(String[] args) {
        try {
            int purchaseAmount = getPurchaseAmount();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            String input = Console.readLine();
            int purchaseAmount = Integer.parseInt(input);
            if (purchaseAmount % 1000 != 0){
                throw new IllegalArgumentException(error_message + "로또 구입 금액은 1,000 단위로 나누어 떨어져야 합니다.");
            }
            return purchaseAmount / 1000;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(error_message + "로또 금액은 숫자여야 합니다.");
        }
    }
}
