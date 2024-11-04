package lotto;
import camp.nextstep.edu.missionutils.Console;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;

    public void start() {
        int purchaseAmount = inputPurchaseAmount();

    }

    private int inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                int amount = Integer.parseInt(Console.readLine());
                if (amount < 0 || amount % LOTTO_PRICE != 0) {
                    throw new IllegalArgumentException("[ERROR] 유효하지 않은 구입 금액입니다. 1000원 단위로 입력해 주세요.");
                }
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
