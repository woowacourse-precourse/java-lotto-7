package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.InputLottoNumber;
import lotto.model.Lotto;
import lotto.model.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoService {
    public List<Lotto> getLotto (int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < (purchaseAmount / 1000); i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private Lotto generateLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lottoNumbers.stream()
                .sorted()
                .collect(Collectors.toList()));
    }


    public Map<Rank, Integer> getRankResult(List<Lotto> lottos, InputLottoNumber inputLottoNumber) {
        Map<Rank, Integer> rankResult = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankResult.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            Rank rank = calculateRank(lotto, inputLottoNumber);
            rankResult.put(rank, rankResult.get(rank) + 1);
        }
        return rankResult;
    }

    public Rank calculateRank(Lotto lotto, InputLottoNumber inputLottoNumber) {
        int matchCount = (int) lotto.getNumbers().stream()
                .filter(inputLottoNumber.getWinningNumbers()::contains)
                .count();
        boolean bonusMatch = lotto.getNumbers().contains(inputLottoNumber.getBonusNumber());
        return Rank.valueOf(matchCount, bonusMatch);
    }

    public int calculateTotalPrize(Map<Rank, Integer> rankResult) {
        int totalPrize = 0;
        for (Map.Entry<Rank, Integer> entry : rankResult.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            totalPrize += rank.getPrize() * count;
        }
        return totalPrize;
    }

    public double calculateYield(int totalPrize, int purchaseAmount) {
        if (purchaseAmount == 0) return 0;
        double yield = (double) totalPrize / purchaseAmount * 100;
        return Math.round(yield * 100) / 100.0; // 소수점 둘째 자리 반올림
    }
}
