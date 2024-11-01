package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.utils.Constant;

public class LottoService {
    public List<Lotto> createLottos(int purchaseAmount) {
        int numberOfLottos = purchaseAmount / 1000;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> lottoNumbers = new ArrayList<>(
                    Randoms.pickUniqueNumbersInRange(Constant.MIN_LOTTO_NUMBER, Constant.MAX_LOTTO_NUMBER,
                            Constant.LOTTO_SIZE));
            Collections.sort(lottoNumbers);
            lottos.add(new Lotto(lottoNumbers));
        }
        return lottos;

    }

    public LottoRank compareLottoNumber(List<Integer> userNumbers, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = (int) userNumbers.stream().filter(winningNumbers::contains).count();
        boolean bonusMatch = userNumbers.contains(bonusNumber);
        return determineRank(matchCount, bonusMatch);
    }

    private LottoRank determineRank(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) {
            return LottoRank.FIRST;
        }
        if (matchCount == 5 && bonusMatch) {
            return LottoRank.SECOND;
        }
        if (matchCount == 5) {
            return LottoRank.THIRD;
        }
        if (matchCount == 4) {
            return LottoRank.FOURTH;
        }
        if (matchCount == 3) {
            return LottoRank.FIFTH;
        }
        return LottoRank.NONE;
    }

    public Map<LottoRank, Integer> calculateWinningStats(List<Lotto> userLottos, List<Integer> winningNumbers,
                                                         int bonusNumber) {
        Map<LottoRank, Integer> winningStats = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            winningStats.put(rank, 0);
        }
        for (Lotto userLotto : userLottos) {
            LottoRank rank = compareLottoNumber(userLotto.getNumbers(), winningNumbers, bonusNumber);
            winningStats.put(rank, winningStats.get(rank) + 1);
        }
        return winningStats;
    }

    public double calculateYield(Map<LottoRank, Integer> winningStats, int purchaseAmount) {
        int totalPrize = 0;
        for (Map.Entry<LottoRank, Integer> entry : winningStats.entrySet()) {
            totalPrize += entry.getKey().getPrizeMoney() * entry.getValue();
        }
        return (double) totalPrize / purchaseAmount * 100;
    }


}
