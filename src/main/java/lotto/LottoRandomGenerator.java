package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoRandomGenerator {
    public static List<Lotto> generate(int size) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }
}
