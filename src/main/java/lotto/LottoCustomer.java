package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoCustomer implements Customer<Lotto>{

    LottoShop lottoShop = new LottoShop();

    @Override
    public List<Lotto> buy(Class<? extends Item> itemType, int money) {
        return  lottoShop.buy(itemType, money);
    }

    @Override
    public void viewTotalProfit(long investment, long profit) {
        System.out.println("총 수익률은 "
                + String.format("%.1f", (double) profit / investment * 100)
                + "%입니다.");
    }

    public void setSelector(NumberSelector numberSelector) {
        lottoShop.setSelector(numberSelector);
    }

    public WinningLotto setWinningLotto(List<Integer> numbers, int bonusNumber) {
        return new WinningLotto(numbers, bonusNumber);
    }

    public void showStatistics(List<Lotto> lottoTickets, WinningLotto winningLotto) {
        System.out.println("당첨 통계\n- - -");
        Map<Prize, Integer> prizeCount = countPrize(lottoTickets, winningLotto);
        for (Prize prize : Prize.values()) {
            if (prize.prizeMoney > 0) {
                System.out.println(prize + " - " + prizeCount.get(prize) + "개");
            }
        }
    }

    private Map<Prize, Integer> countPrize(List<Lotto> lottoTickets, WinningLotto winningLotto) {
        Map<Prize, Integer> prizeCount = new HashMap<>();
        for (Prize prize : Prize.values()) {
            prizeCount.put(prize, 0);
        }
        for (Lotto lotto : lottoTickets) {
            Prize prize = Prize.getPrize(lotto, winningLotto);
            prizeCount.put(prize, prizeCount.get(prize) + 1);
        }
        return prizeCount;
    }

    public long getTotalLottoPrize(List<Lotto> lottoTickets, WinningLotto winningLotto) {
        long total = 0;
        for (Lotto lotto : lottoTickets) {
            total += Prize.getPrize(lotto, winningLotto).prizeMoney;
        }
        return total;
    }
}
