package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    public static void main(String[] args) {
        int purchaseAmount = inputAmount();
        // TODO: 프로그램 구현
    }
    private static int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        if (!isNum(input)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }

        int amount = Integer.parseInt(input);

        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }

        return amount;
    }

    private static boolean isNum(String str) {
        return str.matches("\\d+");
    }

    private static int calculateTicketCount(int amount){
        return amount / LOTTO_PRICE;
    }



}
