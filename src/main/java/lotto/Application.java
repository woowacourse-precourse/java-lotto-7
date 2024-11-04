package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        try {
            int purchaseAmount = inputPurchaseAmount();
            List<Lotto> purchasedLottos = generateLottos(purchaseAmount);
            // 이후 기능 구현
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            int amount = Integer.parseInt(Console.readLine());
            if (amount % LOTTO_PRICE != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력 금액이 올바르지 않습니다.");
        }
    }

    public static List<Lotto> generateLottos(int amount) {
        int numberOfLottos = amount / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}