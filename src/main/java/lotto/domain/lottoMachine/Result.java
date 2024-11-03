package lotto.domain.lottoMachine;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.lotto.Lottos;
import lotto.domain.lottoMachine.dto.GetResultDto;

public class Result {
    private final Map<Rank, Integer> rankCount;

    private Result(Lottos lottos, WinningLotto winningLotto) {
        rankCount = createRankCount(lottos, winningLotto);
    }

    public static Result of(Lottos lottos, WinningLotto winningLotto) {
        return new Result(lottos, winningLotto);
    }

    private Map<Rank, Integer> createRankCount(Lottos lottos, WinningLotto winningLotto) {
        List<Rank> ranks = lottos.getRanks(winningLotto);

        Map<Rank, Integer> rankCount = new EnumMap<>(Rank.class);
        for (Rank rank : ranks) {
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }

        return rankCount;
    }

    public GetResultDto getResults() {
        return new GetResultDto(rankCount);
    }

    public int getReward() {
        return rankCount.entrySet().stream()
            .mapToInt(entry -> entry.getKey().getReward() * entry.getValue())
            .sum();
    }
}
