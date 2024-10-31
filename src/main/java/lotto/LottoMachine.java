package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {

    private Lotto lotto;
    private int bonusNumber;
    private final List<List<Integer>> lottoNumbers = new ArrayList<>();

    public void run() {
        System.out.println("구입금액을 입력해 주세요.");

        int cost = Integer.parseInt(Console.readLine().trim());

        int purchaseCount = cost / 1000;

        System.out.println();

        System.out.println(purchaseCount + "개를 구매했습니다.");

        for (int i = 0; i < purchaseCount; i++) {
            lottoNumbers.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            System.out.println(lottoNumbers.get(i));
        }

        System.out.println();

        System.out.println("당첨 번호를 입력해 주세요.");

        lotto = new Lotto(Arrays.stream(Console.readLine().trim().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));

        System.out.println();

        System.out.println("보너스 번호를 입력해주세요.");

        bonusNumber = Integer.parseInt(Console.readLine().trim());

    }
}
