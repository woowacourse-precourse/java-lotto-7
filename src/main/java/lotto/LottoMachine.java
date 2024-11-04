package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private List<Lotto> purchasedLottos = new ArrayList<>();
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private int getPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int amount = Integer.parseInt(Console.readLine().trim());
                if (amount % LOTTO_PRICE != 0) throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위여야 합니다.");
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void generateLottos(int count) {
        System.out.println(count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).stream()
                    .sorted()
                    .collect(Collectors.toList());
            Lotto lotto = new Lotto(numbers);
            purchasedLottos.add(lotto);
            System.out.println(lotto);
        }
    }
}
