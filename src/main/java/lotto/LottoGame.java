package lotto;
import camp.nextstep.edu.missionutils.Console;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;

    public void start() {
        int purchaseAmount = getValidatePurchaseAmount();

        int lottoCount = calculateLottoCount(purchaseAmount);
        printLottoCount(lottoCount);
    }

    private int getValidatePurchaseAmount() {
        while (true) {
            int amount = getInputAmount();
            if (amount != -1 && isValidAmount(amount)) {
                return amount;
            }
        }
    }

    private int getInputAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        try {
            return Integer.parseInt(Console.readLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해 주세요.");
            return -1;
        }
    }

    private boolean isValidAmount(int amount) {
        if (amount <= 0 || amount % LOTTO_PRICE != 0) {
            System.out.println("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
            return false;
        }
        return true;
    }

    private int calculateLottoCount(int amount) {
        return amount / LOTTO_PRICE;
    }

    private void printLottoCount(int count) {
        System.out.printf("%d개를 구매했습니다.%n", count);
    }
}
