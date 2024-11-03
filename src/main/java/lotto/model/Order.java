package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    public final LottoRound lottoRound;
    public final int orderCount;
    public List<Lotto> orderLotto;

    public Order(LottoRound lottoRound, int orderCount) {
        this.lottoRound = lottoRound;
        this.orderCount = orderCount;
        this.orderLotto = new ArrayList<>();
        for (int i = 0; i < orderCount; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            this.orderLotto.add(lotto);
        }
    }

    @Override
    public String toString() {
        return orderLotto.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }

}
