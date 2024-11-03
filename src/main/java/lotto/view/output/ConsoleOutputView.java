package lotto.view.output;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import lotto.constants.LottoRank;
import lotto.dto.FinalResultsDto;
import lotto.dto.LottoDto;
import lotto.dto.LottosDto;
import lotto.dto.ProfitDto;
import lotto.dto.RankResultsDto;

import static lotto.constants.LottoRank.*;
import static lotto.view.constants.OutputMessages.*;
import static lotto.view.constants.NumberOutputFormat.*;

public class ConsoleOutputView implements OutputView {

    @Override
    public void outputPurchaseLottoList(LottosDto lottosDto) {
        int lottoCount = lottosDto.lottoDtos().size();
        System.out.printf(PURCHASE_NOTICE.getMessage(),lottoCount);

        for (LottoDto lottoDto : lottosDto.lottoDtos()) {
            List<Integer> lottoNumbers = new ArrayList<> (lottoDto.lottoNumbers());

            Collections.sort(lottoNumbers);
            System.out.println(lottoNumbers);
        }
    }


    @Override
    public void outputFinalResult(FinalResultsDto finalResultDto) {
        System.out.print(WINNING_STATISTICS.getMessage());
        outputRankResults(finalResultDto.rankResultsDto());
        outputProfitRate(finalResultDto.profitDto());
    }



    @Override
    public void outputErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    private void outputRankResults(RankResultsDto rankResultsDto) {
        HashMap<Integer, Integer> rankedResults = rankResultsDto.rankResults();

        for (int rank = FIFTH.getRank(); rank >= FIRST.getRank(); rank--) {
            outputRankResult(rank, rankedResults.getOrDefault(rank,0));
        }

    }

    private void outputRankResult(int rank, int winCount){
        LottoRank rankPrize = LottoRank.getByRank(rank);

        int numberMatchCount = rankPrize.getMatchCount();
        int prize = rankPrize.getPrize();

        String formattedPrize = PRIZE_FORMAT.getFormat().format(prize);

        if (rank != SECOND.getRank()) {
            System.out.printf(RESPONSE_RANK.getMessage(), numberMatchCount, formattedPrize, winCount);
        }
        if (rank == SECOND.getRank()) {
            System.out.printf(RESPONSE_RANK_WITH_BONUS.getMessage(), numberMatchCount, formattedPrize, winCount);
        }
    }

    private void outputProfitRate(ProfitDto profitDto) {
        String formattedProfitRate = PROFIT_RATE_FORMAT.getFormat().format(profitDto.profitRate());
        System.out.printf(PROFIT_RATE.getMessage(),formattedProfitRate);
    }


}
