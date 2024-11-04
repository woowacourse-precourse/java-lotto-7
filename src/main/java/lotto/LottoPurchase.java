package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchase {
    private static final int PRICE_PER_LOTTO = 1000;

    public void start() {
        try {
            System.out.println("구입 금액을 입력해 주세요.");
            String input = Console.readLine().trim();
            int purchaseAmount = inputPurchaseAmount(input);
            int lottoCount = purchaseAmount / PRICE_PER_LOTTO;
            System.out.println();
            System.out.println(lottoCount + "개를 구매했습니다.");
            List<Lotto> lottos = generateLottos(lottoCount);
            lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            start();
        }
    }

    public int inputPurchaseAmount(String input) {
        int amount = Integer.parseInt(input);
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
}
