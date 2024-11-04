package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public List<Lotto> generateLottos(int purchaseAmount) {
        int count = purchaseAmount / 1000;
        if (count <= 0) {
            throw new IllegalStateException("[ERROR] 로또를 구매할 수 없습니다. 최소 1,000원을 입력해 주세요.");
        }
        System.out.println(count + "개를 구매했습니다.");

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }
}
