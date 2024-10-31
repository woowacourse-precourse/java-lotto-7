package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoSeller {

    public final static int MAX_LOTTO_SIZE = 1000;
    public final static int LOTTO_PRICE = 1000;

    public List<Lotto> buy(long money) {
        long lottoCount = money / LOTTO_PRICE;
        validateLottoCount(lottoCount);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }

    private void validateLottoCount(long lottoCount) {
        if (lottoCount <= 0) {
            throw new IllegalArgumentException("로또를 살 수 없습니다. 로또는 1000원입니다.");
        }
        if (lottoCount > MAX_LOTTO_SIZE) {
            throw new IllegalArgumentException("로또의 개수가 부족합니다. 최대 1000개만 구입 가능합니다.");
        }
    }
}
