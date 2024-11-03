package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoRankCounter {

    public static Map<String, Integer> countRanks(List<int[]> lottoTickets) {
        // LottoRank의 초기값을 0으로 설정하는 EnumMap 생성
        Map<String, Integer> rankCounts = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank.name(), 0); // 초기값 설정
        }

        // 각 티켓의 등수 카운트를 증가시킴
        for (int[] ticket : lottoTickets) {
            int matchCount = ticket[0];
            boolean matchBonus = ticket[1] == 1;
            String name = LottoRank.valueOf(matchCount, matchBonus);
            rankCounts.put(name, rankCounts.get(name) + 1);
        }
        return rankCounts;
    }
}
