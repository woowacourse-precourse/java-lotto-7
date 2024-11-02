package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.constant.Constant;
import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoService {

    public Lottos issueLottos(Amount amount) {
        List<Lotto> lottos = IntStream.range(0, getLottoCount(amount))
                .mapToObj(i -> issueLotto())
                .collect(Collectors.toList());
        return new Lottos(lottos);
    }

    private int getLottoCount(Amount amount) {
        return amount.getAmount() / Constant.AMOUNT_UNIT;
    }

    private Lotto issueLotto() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(
                Constant.MIN_LOTTO_NUMBER, Constant.MAX_LOTTO_NUMBER, Constant.LOTTO_NUMBER_COUNT
        );
        Collections.sort(lotto);
        return new Lotto(lotto);
    }
}
