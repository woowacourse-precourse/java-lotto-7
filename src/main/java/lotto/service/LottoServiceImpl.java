package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.List;

public class LottoServiceImpl implements LottoService {

    @Override
    public List<Lotto> generateLottos(int amount) {
        int count = amount / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(generateRandomLottoNumbers()));
        }
        return lottos;
    }

    @Override
    public int[] getWinningCount(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        int[] counts = new int[Rank.values().length];
        for (Lotto lotto : lottos) {
            Rank rank = Rank.determineRank(lotto.getNumbers(), winningNumbers, bonusNumber);
            if (rank != Rank.NONE) {
                counts[rank.getIndex()]++;
            }
        }
        return counts;
    }

    @Override
    public double calculateProfitRate(int[] winningCounts, int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("구매 금액은 0보다 커야 합니다.");
        }

        int totalPrize = 0;

        for (Rank rank : Rank.values()) {
            totalPrize += winningCounts[rank.getIndex()] * rank.getPrize();
        }

        if (totalPrize == 0) {
            return 0.0;
        }
        return 100 - ((purchaseAmount - totalPrize) / (double) purchaseAmount * 100);
    }


    private List<Integer> generateRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
