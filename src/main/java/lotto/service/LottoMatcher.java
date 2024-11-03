package lotto.service;

import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import lotto.constants.WinRank;
import lotto.domain.Lotto;
import lotto.domain.WinLotto;

public class LottoMatcher {
    private final List<Lotto> lotties;
    private final EnumMap<WinRank,List<Lotto>> map;
    private final WinLotto winLotto;

    public LottoMatcher(List<Lotto> lotties, WinLotto winLotto) {
        this.lotties = lotties;
        this.winLotto = winLotto;
        this.map = new EnumMap<>(WinRank.class);
        map.put(WinRank.FIRST,new LinkedList<>());
        map.put(WinRank.SECOND,new LinkedList<>());
        map.put(WinRank.THIRD,new LinkedList<>());
        map.put(WinRank.FOURTH,new LinkedList<>());
        map.put(WinRank.FIFTH,new LinkedList<>());
        map.put(WinRank.ETC,new LinkedList<>());
    }

    public void matchLotties() {
        lotties.forEach(lotto->{
            map.get(lotto.matchWinLotto(winLotto)).add(lotto);
        });
    }

    public long getResult(WinRank winRank) {
        return map.get(winRank).size();
    }
}
