package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

// 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다. 로또 1장의 가격은 1,000원이다.
public class Application {
    public static void main(String[] args) {
        int purchaseAmount = inputPurchaseAmount();
        int lottoCount = countLottos(purchaseAmount);
        System.out.println(lottoCount);
    }

    private static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return parsePurchaseAmount(input);
    }

    private static int parsePurchaseAmount(String input) {
        try {
            int purchaseAmount = Integer.parseInt(input);
            validatePurchaseAmount(purchaseAmount);
            return purchaseAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
        }
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 0보다 커야 합니다.");
        }
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위여야 합니다.");
        }
    }

    private static int countLottos(int purchaseAmount) {
        return purchaseAmount / 1000;
    }
}
