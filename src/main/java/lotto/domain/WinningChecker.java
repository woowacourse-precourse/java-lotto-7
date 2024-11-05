package lotto.domain;

import static lotto.constant.LottoValueConstant.LOTTO_PRICE;
import static lotto.constant.LottoValueConstant.NON_RANK;

import java.util.List;
import java.util.Map;

public class WinningChecker {

    public Map<String, Integer> checkWinning(Bonus bonus, Lotto lotto, List<List<Integer>> userLottos) {
        Map<String, Integer> lottoRankCount = LottoRank.LottoRankCollector();

        for (List<Integer> userLotto : userLottos) {
            String rank = determineRank(bonus, lotto, userLotto);
            updateRankCount(lottoRankCount, rank);
        }

        return lottoRankCount;
    }

    private String determineRank(Bonus bonus, Lotto lotto, List<Integer> userLotto) {
        int matchCount = lotto.matching(userLotto);
        boolean matchBonus = bonus.matching(userLotto);
        return LottoRank.valueOf(matchCount, matchBonus);
    }

    private void updateRankCount(Map<String, Integer> rankCountMap, String rank) {
        if (!rank.equals(NON_RANK)) {
            rankCountMap.put(rank, rankCountMap.get(rank) + 1);
        }
    }

    public double calculateReturn(Map<String, Integer> matchingResult, int ticketNumbers) {
        double revenue = calculateRevenue(matchingResult);
        int payMoney = calculatePayMoney(ticketNumbers);
        return ((double)(revenue / payMoney)) * 100;
    }

    public static double calculateRevenue(Map<String, Integer> matchingResult){
        double revenue = 0;
        for (LottoRank rank : LottoRank.values()) {
            revenue += rank.getPrize() * matchingResult.get(rank.name());
        }
        return revenue;
    }

    public static int calculatePayMoney(int ticketNumbers){
        return ticketNumbers * LOTTO_PRICE;
    }
}
