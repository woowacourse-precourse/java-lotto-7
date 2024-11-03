package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.List;

public class LottoServiceImpl implements LottoService {

    private static final int LOTTO_PRICE = 1000;

    @Override
    public List<Lotto> generateLottos(int amount) {
        int count = amount / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }

    @Override
    public int[] getWinningCount(List<Lotto> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        int[] winCounts = new int[5]; // 3~6개 일치 카운트
        for (Lotto lotto : lottoNumbers) {
            Rank rank = Rank.determineRank(lotto.getNumbers(), winningNumbers, bonusNumber);
            if (rank != null) {
                winCounts[rank.ordinal()]++;
            }
        }
        return winCounts;
    }

    @Override
    public double calculateProfitRate(int[] winningCounts, int purchaseAmount) {
        int totalPrize = 0;
        for (int i = 0; i < winningCounts.length; i++) {
            totalPrize += winningCounts[i] * Rank.values()[i].getPrize();
        }
        return Math.round((totalPrize / (double) purchaseAmount) * 100 * 100.0) / 100.0;
    }
}
