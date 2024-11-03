package lotto;

import static java.lang.Integer.parseInt;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final int PER_LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        int purchasePrice; // 로또 구입금액
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String purchasePriceStr = Console.readLine();
                purchasePrice = parseInt(purchasePriceStr);
                if (purchasePrice <= 0 || purchasePrice % PER_LOTTO_PRICE != 0) {
                    throw new IllegalArgumentException("[ERROR] 1,000원 단위의 올바른 금액을 입력하세요.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}