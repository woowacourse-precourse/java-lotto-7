package lotto.domain;

import java.util.ArrayList;
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


}
