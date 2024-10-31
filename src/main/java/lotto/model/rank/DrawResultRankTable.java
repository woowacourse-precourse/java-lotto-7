package lotto.model.rank;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class DrawResultRankTable {

    private final EnumMap<RankCondition, Integer> result;

    private DrawResultRankTable(EnumMap<RankCondition, Integer> result) {
        this.result = result;
    }

    public static DrawResultRankTable initiate() {
        EnumMap<RankCondition, Integer> rankTable = new EnumMap<>(RankCondition.class);
        Arrays.stream(RankCondition.values())
                .forEach(rank -> rankTable.put(rank, 0));
        return new DrawResultRankTable(rankTable);
    }

    public void updateResultRankTable(final RankCondition rank) {
        int newValue = result.get(rank) + 1;
        result.put(rank, newValue);
    }

    public int getRankValue(final RankCondition rank) {
        return result.getOrDefault(rank, 0);
    }

    public Stream<Entry<RankCondition, Integer>> initiateReadOnlyStream() {
        return result.entrySet().stream();
    }
}
