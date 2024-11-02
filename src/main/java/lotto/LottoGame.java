package lotto;

import java.util.Scanner;

public class LottoGame {
    private final Scanner scanner = new Scanner(System.in);

    private int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = scanner.nextLine();

        try {
            int amount = Integer.parseInt(input);
            if (amount <= 0 || amount % 1000 != 0) {
                throw new NumberFormatException("[ERROR] 구입 금액은 1,000원 단위의 양수로 입력해야 합니다.");
            }
            return amount;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 유효한 숫자를 입력하세요.");
            return inputAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputAmount();
        }
    }
}
