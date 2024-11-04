package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoNumberGenerator {
    public List<Lotto> generate(int lottoRound) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoRound; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoList.add(new Lotto(numbers));
        }
        return lottoList;
    }
}
