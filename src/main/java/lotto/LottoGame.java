package lotto;

import java.util.List;
import java.util.Scanner;

public class LottoGame {
    private final LottoMachine lottoMachine = new LottoMachine();
    private final Scanner scanner = new Scanner(System.in);

    private int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = scanner.nextLine();

        try {
            int amount = Integer.parseInt(input);
            if (amount <= 0 || amount % 1000 != 0) {
                throw new IllegalArgumentException();
            }
            return amount;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 구입금액은 숫자로 입력하세요.");
            return inputAmount();
        }
    }
}
