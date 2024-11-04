package lotto;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.text.NumberFormat;

public class LottoCollection {
    private final List<Lotto> tickets;
    private final Map<Rank, Integer> result;

    public LottoCollection(int num) {
        this.tickets = new ArrayList<>();
        this.result = new HashMap<>();

        for (int index = 0; index < num; index++) {
            tickets.add(new Lotto());
        }
    }

    public List<Lotto> getTickets() {
        return tickets;
    }

    // check results of Lotteries
    public void checkResult(Lotto winningLotto, int bonus) {
        result.clear();

        for (Lotto lottery : tickets) {
            int matchCount = lottery.countMatchingNumbers(winningLotto);
            boolean checkBonus = matchCount == 5 && lottery.containBonusNumber(bonus);

            Rank rank = Rank.searchRank(matchCount, checkBonus);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
    }

    // print results of Lotteries
    public void printResult(int budget) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        int totalprize = 0;
        double revenueRate;

        for (Rank rank : Rank.values()) {
            int count = result.getOrDefault(rank, 0);
            if (rank != Rank.NONE) {
                System.out.println(rank.getDescription() + " - " + count);
                totalprize += rank.getPrize() * count;
            }
        }
        revenueRate = (double) totalprize / budget;
        revenueRate = Math.round(revenueRate * 10) / 10.0; // 소수점 둘째자리에서 반올림

        // print revenue with formatted type (, 포함)
        NumberFormat formatter = NumberFormat.getInstance();
        String formattedRevenue = formatter.format(revenueRate);

        System.out.println("총 수익률은 " + formattedRevenue + "%입니다.");
    }

}
