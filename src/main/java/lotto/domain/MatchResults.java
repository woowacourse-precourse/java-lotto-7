package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.dto.LottoDto;
import lotto.dto.LottosDto;

public class MatchResults {
    private final List<MatchResult> matchResults;

    private MatchResults(List<MatchResult> matchResults) {
        this.matchResults = matchResults;
    }

    public static MatchResults createMatchResults(LottosDto lottosDto, WinningLotto winningLotto) {
        List<MatchResult> matchResults = new ArrayList<>();
        for (LottoDto lottoDto: lottosDto.lottoDtos()){
            matchResults.add(winningLotto.getMatchResult(lottoDto.lottoNumbers()));
        }
        return new MatchResults(matchResults);
    }

    public HashMap<Integer, Integer> getRankResults() {
        HashMap<Integer, Integer> rankResults = new HashMap<>();

        for (MatchResult matchResult : matchResults) {
            int rank = matchResult.getRank();

            rankResults.put(rank, rankResults.getOrDefault(rank, 0) + 1);
        }

        rankResults.remove(-1);

        return rankResults;
    }


}
