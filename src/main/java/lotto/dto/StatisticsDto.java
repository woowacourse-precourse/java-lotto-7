package lotto.dto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.stream.Collectors;
import lotto.domain.Rank;

public record StatisticsDto(EnumMap<Rank, Integer> rankStatistics, float profitRate) {

    public static StatisticsDto of(EnumMap<Rank, Integer> rankStatistics, float profitRate) {
        return new StatisticsDto(rankStatistics, profitRate);
    }

    public String getStatisticsAsString() {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.NONE)
                .sorted(Comparator.comparingInt(Rank::getMatchNumber))
                .map(rank -> String.format("%s - %d개", rank, rankStatistics.getOrDefault(rank, 0)))
                .collect(Collectors.joining("\n"));
    }

    public float getProfitRate(){
        return profitRate;
    }
}
