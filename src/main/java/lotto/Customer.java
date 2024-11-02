package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.numberSelector.NumberSelector;

public class Customer {
    private int cost;
    private LottoShop lottoShop = new LottoShop();
    private Reader reader = new Reader();

    public List<Lotto> buy(NumberSelector selector) {
        int money = reader.readMoney();
        cost = money - (money % LottoShop.PRICE);

        return lottoShop.buy(money, selector);
    }

    public WinningLotto setWinningLotto() {
        List<Integer> numbers = reader.readLottoNumbers();
        int bonusNum = reader.readBonusNumber(numbers);
        return lottoShop.setWinningLotto(numbers, bonusNum);
    }

    public Map<Prize, Integer> countPrize(List<Lotto> lottoTickets, WinningLotto winningLotto) {
        List<Prize> wins = new ArrayList<>();
        for (Lotto lotto : lottoTickets) {
            wins.add(Prize.getPrize(lotto, winningLotto));
        }

        Map<Prize, Integer> prizeCounts = new HashMap<>();
        for (Prize prize : Prize.values()) {
            prizeCounts.put(prize, Collections.frequency(wins, prize));
        }

        return prizeCounts;
    }

    public void statistics(Map<Prize, Integer> prizeCounts) {
        System.out.println("당첨 통계");
        System.out.println("- - -");

        long totalPrizeMoney = 0;
        for (Prize key : Prize.values()) {
            int count = prizeCounts.get(key);
            totalPrizeMoney += (long) count * key.prizeMoney;
            System.out.println(key + " - " + count + "개");
        }

        System.out.println("총 수익률은 " +
                String.format("%.1f", (float) totalPrizeMoney / cost * 100) +
                "%입니다.");
    }
}
