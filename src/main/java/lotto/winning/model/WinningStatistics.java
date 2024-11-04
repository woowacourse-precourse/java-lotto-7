package lotto.winning.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.common.constant.RankConstant;
import lotto.dto.NumberOfMatchingDto;
import lotto.dto.NumberOfTicketsDto;

public class WinningStatistics {
    private Map<RankConstant, Integer> ranks;
    private final List<Integer> numberOfMatching;
    private final int payment;
    private double rateOfWinning;

    public WinningStatistics() {
      numberOfMatching = NumberOfMatchingDto.getNumberOfMatchingDto().numberOfMatching();
      payment = NumberOfTicketsDto.getNumberOfTicketsDto().getPayment();
    }

    public Map<RankConstant, Integer> getRanksOfLottoTickets() {
        calculateRanks();
        return ranks;
    }

    public double getRateOfReturn() {
        calculateRateOfReturn();
        return rateOfWinning;
    }


    private void calculateRanks() {
        int firstRank = Collections.frequency(numberOfMatching, 6);
        int secondRank = Collections.frequency(numberOfMatching, 10);
        int thirdRank = Collections.frequency(numberOfMatching, 5);
        int fourthRank = Collections.frequency(numberOfMatching, 4);
        int fifthRank = Collections.frequency(numberOfMatching, 3);

        ranks = new HashMap<>(5);
        ranks.put(RankConstant.FIRSTRANK, firstRank);
        ranks.put(RankConstant.SECONDRANK, secondRank);
        ranks.put(RankConstant.THIRDRANK, thirdRank);
        ranks.put(RankConstant.FOURTHRANK, fourthRank);
        ranks.put(RankConstant.FIFTHRANK, fifthRank);
    }

    private void calculateRateOfReturn() {
        double sum = 0;
        for (RankConstant rankConstant : ranks.keySet()) {
            sum += rankConstant.getAmount() * ranks.get(rankConstant);
        }
        sum *= (100.0 / payment);
        rateOfWinning =  Math.round(sum * 100) / 100.0;
    }
}
