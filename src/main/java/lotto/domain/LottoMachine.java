package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final static int MAX_LOTTO_SIZE = 1000;

    public List<Lotto> issue(long lottoSize) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoSize; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private void validateLottoSize(long lottoSize) {
        if (lottoSize > MAX_LOTTO_SIZE) {
            throw new IllegalArgumentException("로또의 개수가 부족합니다. 최대 1000개만 구입 가능합니다.");
        }
    }
}
