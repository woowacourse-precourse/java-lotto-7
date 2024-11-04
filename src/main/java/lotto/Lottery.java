package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lottery {
    private static final List<Lotto> LOTTOES = new ArrayList<>();
    public void issue(String purchaseAmount) {
        int issue = Integer.parseInt(purchaseAmount) / 1000;
        System.out.println(issue + "개를 구매했습니다.");

        for (int i = 0; i < issue; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            LOTTOES.add(new Lotto(numbers));
            System.out.println(Arrays.toString(numbers.toArray()));
        }
    }
}
