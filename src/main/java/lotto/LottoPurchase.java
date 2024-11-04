package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchase {
    private static final int PRICE_PER_LOTTO = 1000;
    private int totalCost;
    private List<Lotto> userLottos;

    public void start() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                String input = Console.readLine().trim();
                totalCost = inputPurchaseAmount(input);
                int lottoCount = totalCost / PRICE_PER_LOTTO;
                System.out.println();
                System.out.println(lottoCount + "개를 구매했습니다.");
                userLottos = generateLottos(lottoCount);
                userLottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Lotto> getUserLottos() {
        return userLottos;
    }

    public int inputPurchaseAmount(String input) {
        int amount;
        try {
            amount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자여야 합니다.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 0보다 커야 합니다.");
        }
        if (amount % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");
        }
        return amount;
    }

    public List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public int getTotalCost() {
        return totalCost;
    }
}
