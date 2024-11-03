package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    public final LottoRound lottoRound;
    public final int orderCount;
    public List<Lotto> orderLotto;
    private final List<Integer> matchCount;

    public Order(LottoRound lottoRound, int orderCount) {
        this.lottoRound = lottoRound;
        this.orderCount = orderCount;
        this.orderLotto = new ArrayList<>();
        this.matchCount = new ArrayList<>(Collections.nCopies(8, 0));
        for (int i = 0; i < orderCount; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            this.orderLotto.add(lotto);
        }
    }

    public void countmatch(){
        for (Lotto lotto : orderLotto) {
            int matches = lotto.compare(this.lottoRound.getWinningLotto());
            boolean hasBonus = lotto.bonuscheck(this.lottoRound.getBonusNumber());

            if(matches == 5 && hasBonus) {
                matchCount.set(7, matchCount.get(7) + 1);
                return;
            }
            matchCount.set(matches, matchCount.get(matches) + 1);
        }
    }

    public List<Integer> getMatchCount() {
        return matchCount;
    }

    @Override
    public String toString() {
        return orderLotto.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }

}
