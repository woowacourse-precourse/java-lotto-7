package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoSystem {
    private static final String PURCHASE_GUIDE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_RESULT = "%d개를 구매했습니다.";

    private final List<Lotto> purchasedLottos = new ArrayList<>();

    public void start() {
        Money money = purchaseMoney();
        generateLottos(money);
        displayPurchaseResult();
    }

    private Money purchaseMoney() {
        System.out.println(PURCHASE_GUIDE);
        return new Money(Console.readLine());
    }

    private void generateLottos(Money money) {
        int count = money.getLottoCount();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(generateNumbers());
            purchasedLottos.add(lotto);
        }
    }

    private List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
                .stream()
                .sorted()
                .toList();
    }

    private void displayPurchaseResult() {
        System.out.printf(PURCHASE_RESULT + "%n", purchasedLottos.size());
        purchasedLottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }
}