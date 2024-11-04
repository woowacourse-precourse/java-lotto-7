package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
            int purchaseAmount = getPurchaseAmount();
            List<Lotto> purchasedLottos = generateLottos(purchaseAmount / 1000);
    }

    // 구입 금액 입력 처리
    private static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        if (amount < 1000 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 유효한 금액을 입력해 주세요 (1,000원 단위).");
        }
        return amount;
    }

    // 로또 발행
    private static List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }
}