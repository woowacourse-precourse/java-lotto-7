package lotto.model.rank;

import java.util.Arrays;
import java.util.EnumMap;

public class DrawResultRankTable {

    private final EnumMap<Rank, Integer> result;

    private DrawResultRankTable(EnumMap<Rank, Integer> result) {
        this.result = result;
    }

    public static DrawResultRankTable initiate() {
        EnumMap<Rank, Integer> rankTable = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values())
                .forEach(rank -> rankTable.put(rank, 0));
        return new DrawResultRankTable(rankTable);
    }

    public void updateResultRankTable(Rank rank) {
        int newValue = result.get(rank) + 1;
        result.put(rank, newValue);
    }

    public int getRankValue(Rank rank) {
        return result.getOrDefault(rank, 0);
    }
}
