package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final List<List<Integer>> lottoNumbers = new ArrayList<>();

    public void run() {
        System.out.println("구입금액을 입력해 주세요.");

        int cost = Integer.parseInt(Console.readLine());

        int purchaseCount = cost/1000;

        System.out.println(purchaseCount + "개를 구매했습니다.");

        for (int i = 0; i < purchaseCount; i++) {
            lottoNumbers.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            System.out.println(lottoNumbers.get(i));
        }

    }
}
