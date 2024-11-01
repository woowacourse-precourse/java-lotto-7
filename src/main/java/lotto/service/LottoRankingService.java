package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.PurchasedLottoNumbers;
import lotto.view.InputView;

public class LottoRankingService {
    public static int[] calculateLottoRank(Lotto lotto, ArrayList<List<Integer>> purchasedLottoNumbers, BonusNumber bonusNumber) {
        int[] rank = new int[5];

        for (List<Integer> purchasedLottoNumber : purchasedLottoNumbers) {
            int matchCount = countMatches(lotto, purchasedLottoNumber);
            updateRank(rank, matchCount, purchasedLottoNumber.contains(bonusNumber.getBonusNumber()));
        }

        return rank;
    }
    public static int countMatches(Lotto lotto, List<Integer> purchasedLottoNumber) {
        int matchCount = 0;
        for (Integer number : purchasedLottoNumber) {
            if (lotto.getNumbers().contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public static void updateRank(int[] rank, int matchCount, boolean hasBonus) {
        if (matchCount == 3) {
            rank[0]++;
            return;
        }
        if (matchCount == 4) {
            rank[1]++;
            return;
        }
        if (matchCount == 5) {
            if (hasBonus) {
                rank[3]++;
                return;
            }
            rank[2]++;
            return;
        }
        if (matchCount == 6) {
            rank[4]++;
        }
    }

    public static double getTotalRate(int[] rank, int money) {
        int total = rank[0] * 5000 + rank[1] * 50000 + rank[2] * 1500000 + rank[3] * 30000000 + rank[4] * 2000000000;
        double totalRate = (double) total / money * 100;
        totalRate = Math.round(totalRate * 10) / 10.0;
        return totalRate;
    }

}
