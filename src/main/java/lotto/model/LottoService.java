package lotto.model;

import lotto.status.LottoConstants;
import lotto.status.LottoPrize;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class LottoService implements LottoConstants {


    public double calculateProfitRate(long sumPrize, int amount) {
        BigDecimal rate = new BigDecimal((double) sumPrize / amount * 100);
        return rate.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public long sumPrize(int[] prizeTickets) {
        long sum = 0;
        for (int i = 0; i < prizeTickets.length; i++) {
            sum += (long) prizeTickets[i] * LottoPrize.values()[i].getMoney();
        }
        return sum;
    }

    public int[] calculateTicketRank(List<Lotto> tickets, List<Integer> luckyNumbers, int bonus) {
        int[] rank = new int[5];
        for (Lotto ticket : tickets) {
            int count = accordNumberCount(ticket.getNumbers(), luckyNumbers);

            if (count == 6) {
                rank[0]++;
                continue;
            }
            if (count == 5 && accordBonusNumber(ticket.getNumbers(), bonus)) {
                rank[1]++;
                continue;
            }
            if (count == 5) {
                rank[2]++;
                continue;
            }
            if (count == 4) {
                rank[3]++;
                continue;
            }
            if (count == 3) {
                rank[4]++;
            }
        }
        return rank;
    }

    private Boolean accordBonusNumber(List<Integer> ticket, int bonusNumbers) {
        return ticket.contains(bonusNumbers);
    }

    private int accordNumberCount(List<Integer> ticket, List<Integer> luckyNumbers) {
        return (int) ticket.stream()
                           .filter(luckyNumbers::contains)
                           .count();
    }
}
