package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoRunner {
    public static void start() {
        int money = 1;
        while (money % 1000 != 0) {
            System.out.println("구입금액을 입력해 주세요.");
            money = Integer.parseInt(Console.readLine());
            try {
                validate(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money / 1000; i++) {
            lottos.add(new Lotto(
                    Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    private static void validate(int money) throws IllegalArgumentException {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000 단위의 숫자로 입력해주세요.");
        }
    }
}
