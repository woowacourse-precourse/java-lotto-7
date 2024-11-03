package lotto.domain.lottoMachine;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.lotto.Lottos;
import lotto.domain.lottoMachine.dto.GetResultDto;

public class Result {
    private final Map<Rank, Integer> rankCount;

    private Result(final Lottos lottos,final WinningLotto winningLotto) {
        rankCount = createRankCount(lottos, winningLotto);
    }

    public static Result of(final Lottos lottos, final WinningLotto winningLotto) {
        return new Result(lottos, winningLotto);
    }

    public GetResultDto getResults() {
        return new GetResultDto(rankCount);
    }

    public long getReward() {
        return rankCount.entrySet().stream()
            .mapToLong(entry -> (long) entry.getKey().getReward() * entry.getValue())
            .sum();
    }

    private Map<Rank, Integer> createRankCount(final Lottos lottos, final WinningLotto winningLotto) {
        List<Rank> ranks = lottos.getRanks(winningLotto);

        Map<Rank, Integer> rankCount = new EnumMap<>(Rank.class);
        for (Rank rank : ranks) {
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }

        return rankCount;
    }
}
