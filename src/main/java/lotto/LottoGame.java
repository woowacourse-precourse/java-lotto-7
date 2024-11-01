package lotto;
import camp.nextstep.edu.missionutils.Console;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;

    public void start() {
        int purchaseAmount = getPurchaseAmount();
    }
    private int getPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int amount = Integer.parseInt(Console.readLine());

                if (amount % LOTTO_PRICE != 0) {
                    throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
                }
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
