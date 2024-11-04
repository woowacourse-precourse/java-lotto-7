package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoInputHandler {
    public int getTotalPurchase() {
        while (true) {
            System.out.println("\n구입금액을 입력해 주세요.");
            try {
                return Integer.parseInt(Console.readLine().trim());
            } catch (IllegalArgumentException e) {
                System.out.printf("[ERROR] 유효한 정수를 입력하세요. 다시 입력해 주세요. (%s)\n", e.getMessage());
            }
        }
    }
}