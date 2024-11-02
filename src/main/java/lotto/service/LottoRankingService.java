package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
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
        return (int) purchasedLottoNumber.stream()
                .filter(lotto.getNumbers() :: contains)
                .count();
    }

    public static void updateRank(int[] rank, int matchCount, boolean hasBonus) {
        if (matchCount < 3) return;

        if (matchCount == 3) {
            rank[0]++;
            return;
        }

        if (matchCount == 4) {
            rank[1]++;
            return;
        }

        if (matchCount == 5) {
            rank[hasBonus ? 3 : 2]++;
        }

        if (matchCount == 6) {
            rank[4]++;
        }
    }


    public static double getTotalRate(int[] rank, int money) {
        int[] prizes = {5000, 50000, 1500000, 30000000, 2000000000};
        int total = IntStream.range(0, rank.length)
                .map(i -> rank[i] * prizes[i])
                .sum();

        return Math.round((double) total / money * 1000) / 10.0;
    }

}
