package lotto.dto;

import static lotto.common.LottoConstant.PRIZE_FIVE_MATCHES;
import static lotto.common.LottoConstant.PRIZE_FIVE_WITH_BONUS;
import static lotto.common.LottoConstant.PRIZE_FOUR_MATCHES;
import static lotto.common.LottoConstant.PRIZE_SIX_MATCHES;
import static lotto.common.LottoConstant.PRIZE_THREE_MATCHES;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Rank;

public class WinningStatistics {
    private static final String THREE_MATCHES = "3개 일치 (%s원) - %d개%n";
    private static final String FOUR_MATCHES = "4개 일치 (%s원) - %d개%n";
    private static final String FIVE_MATCHES = "5개 일치 (%s원) - %d개%n";
    private static final String FIVE_WITH_BONUS = "5개 일치, 보너스 볼 일치 (%s원) - %d개%n";
    private static final String SIX_MATCHES = "6개 일치 (%s원) - %d개%n";
    private static final String PROFIT_RATE = "총 수익률은 %.1f%%입니다.";

    private int threeMatches = 0;
    private int fourMatches = 0;
    private int fiveMatches = 0;
    private int fiveWithBonus = 0;
    private int sixMatches=0;
    private double profitRate = 0;

    public WinningStatistics(List<Lotto> lottoTickets, int amount){
        List<Rank> ranks = lottoTickets.stream()
                .map(Lotto::getRank)
                .toList();

        int totalPrice = ranks.stream()
                .map(this::addEachResult)
                .mapToInt(Integer::intValue)
                .sum();

        profitRate = ((double) totalPrice)/amount * 100;
    }


    private int addEachResult(Rank rank){
        int price = 0;
        if(rank == Rank.SIX_MATCHES){
            price += PRIZE_SIX_MATCHES;
            sixMatches+=1;
        } else if(rank == Rank.FIVE_WITH_BONUS){
            price += PRIZE_FIVE_WITH_BONUS;
            fiveWithBonus+=1;
        } else if(rank == Rank.FIVE_MATCHES){
            price += PRIZE_FIVE_MATCHES;
            fiveMatches+=1;
        } else if(rank == Rank.FOUR_MATCHES){
            price += PRIZE_FOUR_MATCHES;
            fourMatches+=1;
        } else if(rank == Rank.THREE_MATCHES){
            price += PRIZE_THREE_MATCHES;
            threeMatches+=1;
        }
        return price;
    }
    public String toFinalString(){
        return String.format(
                THREE_MATCHES + FOUR_MATCHES + FIVE_MATCHES + FIVE_WITH_BONUS + SIX_MATCHES + PROFIT_RATE,
                formatPrize(PRIZE_THREE_MATCHES), threeMatches,
                formatPrize(PRIZE_FOUR_MATCHES), fourMatches,
                formatPrize(PRIZE_FIVE_MATCHES), fiveMatches,
                formatPrize(PRIZE_FIVE_WITH_BONUS), fiveWithBonus,
                formatPrize(PRIZE_SIX_MATCHES), sixMatches, profitRate
        );
    }

    private static String formatPrize(int prize) {
        return String.format("%,d", prize); // Formats the prize with commas
    }
}
