package lotto.service;

import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import lotto.constants.WinRank;
import lotto.domain.Lotto;
import lotto.domain.WinNumber;

public class LottoMatcher {
    private final List<Lotto> lottoes;
    private final EnumMap<WinRank, List<Lotto>> map;
    private final WinNumber winNumber;

    public LottoMatcher(List<Lotto> lottoes, WinNumber winNumber) {
        this.lottoes = lottoes;
        this.winNumber = winNumber;
        this.map = new EnumMap<>(WinRank.class);
        map.put(WinRank.FIRST, new LinkedList<>());
        map.put(WinRank.SECOND, new LinkedList<>());
        map.put(WinRank.THIRD, new LinkedList<>());
        map.put(WinRank.FOURTH, new LinkedList<>());
        map.put(WinRank.FIFTH, new LinkedList<>());
        map.put(WinRank.ETC, new LinkedList<>());
    }

    /**
     * 구입한 로또를 당첨 번호와 비교하여 순위 별로 구분한다.
     */
    public void matchLottoes() {
        lottoes.forEach(lotto -> {
            map.get(lotto.compareWinNumber(winNumber)).add(lotto);
        });
    }

    /**
     * 원하는 순위의 당첨 갯수를 확인한다.
     *
     * @param winRank 원하는 순위
     * @return 원하는 순위의 당첨 갯수.
     */
    public long getResult(WinRank winRank) {
        return map.get(winRank).size();
    }
}
