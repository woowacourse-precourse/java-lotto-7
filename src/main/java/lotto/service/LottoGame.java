package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

public class LottoGame {

    public static final int LOTTO_PRICE = 1000;


    private List<Lotto> purchaseLottos(int amount){
        return IntStream.rangeClosed(0, amount / LOTTO_PRICE)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .collect(Collectors.toList());
    }

    private LottoResult calculateResult(List<Lotto> purchasedLottos, Lotto winningLotto, int bonusNumber) {
        LottoResult result = new LottoResult();
        purchasedLottos.forEach(lotto -> result.addRank(LottoRank.getRank(lotto, winningLotto, bonusNumber)));
        return result;
    }

}
