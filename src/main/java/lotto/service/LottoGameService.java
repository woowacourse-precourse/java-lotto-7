package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoGamePlayer;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;

public class LottoGameService {
    private final static int ONE_LOTTO_PRICE = 1000;
    private final LottoGamePlayer player;
    private WinningLotto winningLotto;

    public LottoGameService(LottoGamePlayer player) {
        this.player = player;
    }

    public List<Lotto> generatePurchaserLottos(int purchaseCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            List<Integer> randomLottoNumbers = generateRandomLottoNumbers();
            Lotto lotto = new Lotto(randomLottoNumbers);
            lottos.add(lotto);
        }
        player.purchaseLottos(lottos);
        return lottos;
    }

    private List<Integer> generateRandomLottoNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        sortNumbersAscending(randomNumbers);
        return randomNumbers;
    }

    private void sortNumbersAscending(List<Integer> randomNumbers) {
        Collections.sort(randomNumbers);
    }

    public void generateWinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningLotto = new WinningLotto(winningNumbers, bonusNumber);
    }

    public Map<Rank, Integer> calculateRank() {
        return calculateRankAndPrize().getRankResult();
    }

    public String calculateProfitRate() {
        RankAndPrize result = calculateRankAndPrize();
        int purchasePrice = result.getTotalLottos() * ONE_LOTTO_PRICE;
        double profitRate = ((double) result.getTotalPrizeMoney() / purchasePrice) * 100;
        return String.format("%.1f%%", Math.round(profitRate * 10) / 10.0);
    }

    private RankAndPrize calculateRankAndPrize() {
        Map<Rank, Integer> rankResult = initializeRankResult();
        List<Lotto> purchasedLottos = player.getPurchasedLottos();
        int totalPrizeMoney = 0;
        for (Lotto purchasedLotto : purchasedLottos) {
            Rank rank = winningLotto.calculateRank(purchasedLotto);
            if (rank != null) {
                rankResult.put(rank, rankResult.get(rank) + 1);
                totalPrizeMoney += rank.getPrize();
            }
        }
        return new RankAndPrize(rankResult, totalPrizeMoney, purchasedLottos.size());
    }

    private Map<Rank, Integer> initializeRankResult() {
        Map<Rank, Integer> rankResult = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankResult.put(rank, 0);
        }
        return rankResult;
    }

    private static class RankAndPrize {
        private final Map<Rank, Integer> rankResult;
        private final int totalPrizeMoney;
        private final int totalLottos;

        public RankAndPrize(Map<Rank, Integer> rankResult, int totalPrizeMoney, int totalLottos) {
            this.rankResult = rankResult;
            this.totalPrizeMoney = totalPrizeMoney;
            this.totalLottos = totalLottos;
        }

        public Map<Rank, Integer> getRankResult() {
            return rankResult;
        }

        public int getTotalPrizeMoney() {
            return totalPrizeMoney;
        }

        public int getTotalLottos() {
            return totalLottos;
        }
    }
}
