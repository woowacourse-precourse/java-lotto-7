package lotto.view.output;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import lotto.constants.LottoRankPrize;
import lotto.dto.FinalResultsDto;
import lotto.dto.LottoDto;
import lotto.dto.LottosDto;
import lotto.dto.ProfitDto;
import lotto.dto.RankResultsDto;

public class ConsoleOutputView implements OutputView {
    String RESPONSE_RANK = "d%개 일치 (d원) - d%개";
    String RESPONSE_RANK_FOR_BONUS = "d%개 일치, 보너스 볼 일치 (d원) - d%개";
    String PURCHASE_NOTICE = "\n%d개를 구매했습니다%n";
    @Override
    public void outputPurchaseLottoList(LottosDto lottosDto) {
        int lottoCount = lottosDto.lottoDtos().size();
        System.out.printf(PURCHASE_NOTICE,lottoCount);

        for (LottoDto lottoDto : lottosDto.lottoDtos()) {
            List<Integer> lottoNumbers = new ArrayList<> (lottoDto.lottoNumbers());

            Collections.sort(lottoNumbers);
            System.out.println(lottoNumbers);
        }
    }


    @Override
    public void outputFinalResult(FinalResultsDto finalResultDto) {
        System.out.print("\n당첨 통계\n---");
        outputRankResults(finalResultDto.rankResultsDto());
        outputProfitRate(finalResultDto.profitDto());
    }



    @Override
    public void outputErrorMessage(String errorMessage) {
        System.out.println("\n[ERROR] " + errorMessage);
    }

    private void outputRankResults(RankResultsDto rankResultsDto) {
        HashMap<Integer, Integer> rankedResults = rankResultsDto.rankResults();
        for (int rank: rankedResults.keySet()) {
            outputRankResult(rank, rankedResults.getOrDefault(rank,0));
        }

    }

    private void outputRankResult(int rank, int winCount){
        LottoRankPrize rankPrize = LottoRankPrize.getByRank(rank);

        int numberMatchCount = rankPrize.getMatchCount();
        int prize = rankPrize.getPrize();

        if (rank == 2) {
            System.out.printf(RESPONSE_RANK + "%n", winCount, prize, numberMatchCount);
        }
        if (rank != 2) {
            System.out.printf(RESPONSE_RANK_FOR_BONUS + "%n", winCount, prize, numberMatchCount);
        }
    }

    private void outputProfitRate(ProfitDto profitDto) {
        System.out.printf("\n총 수익율은 %.1f%%입니다",profitDto.profitRate());
    }




}
