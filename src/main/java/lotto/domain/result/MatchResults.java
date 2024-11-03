package lotto.domain.result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.constants.LottoRank;
import lotto.dto.FinalResultsDto;
import lotto.dto.LottoDto;
import lotto.dto.LottosDto;
import lotto.dto.ProfitDto;
import lotto.dto.RankResultsDto;

import static lotto.constants.LottoTicket.LOTTO_PRICE;

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

    public FinalResultsDto buildFinalResultsDto(){

        RankResultsDto rankResultsDto = buildRankResultsDto();
        ProfitDto profitDto = buildProfitDto(rankResultsDto.rankResults());

        return new FinalResultsDto(rankResultsDto, profitDto);
    }

    private RankResultsDto buildRankResultsDto() {
        HashMap<Integer, Integer> rankResults = new HashMap<>();

        for (MatchResult matchResult : matchResults) {
            int rank = matchResult.getRank();

            rankResults.put(rank, rankResults.getOrDefault(rank, 0) + 1);
        }

        rankResults.remove(-1);

        return new RankResultsDto(rankResults);
    }

    private ProfitDto buildProfitDto(HashMap<Integer, Integer> rankResults) {
        long totalProfit = 0;
        for (LottoRank rank: LottoRank.values()) {
            long rankCount = rankResults.getOrDefault(rank.getRank(), 0);
            totalProfit += rankCount * rank.getPrize();
        }

        double profitRate = ((double) totalProfit) / (double)( matchResults.size() * LOTTO_PRICE.getValue()) * 100.0f;

        return new ProfitDto(totalProfit, profitRate);

    }







}
