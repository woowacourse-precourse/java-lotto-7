package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class Utils {

    public int parseStringToInt(String inputPrice) {
        return Integer.parseInt(inputPrice);
    }

    public List<Lotto> generateRandomLottoNumbers(int price) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < price / 1000; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }

    public List<Integer> convertToIntegerList(String numbers) {
        return Arrays.stream(numbers.split(",")).map(Integer::parseInt).toList();
    }

    public Map<Rank, Integer> evaluateLottoRanks(Lotto winningNumber, int bonusNumber, List<Lotto> lottos) {
        Map<Rank, Integer> resultCounts = new HashMap<>();
        for (Rank rank : Rank.values()) {
            resultCounts.put(rank, 0);
        }
        for (Lotto lotto : lottos) {
            matchLottoNumber(resultCounts, winningNumber, bonusNumber, lotto);
        }
        return resultCounts;
    }

    private void matchLottoNumber(Map<Rank, Integer> resultCounts, Lotto winningNumber, int bonusNumber, Lotto lotto) {
        int count = 0, bonusCount = 0;
        for (int i = 0; i < 6; i++) {
            if (lotto.matchNumber(winningNumber.getIndex(i))) {
                count++;
            }
        }
        if (lotto.matchNumber(bonusNumber)) {
            bonusCount++;
        }
        if (count >= 3) {
            Rank rank = rankingLotto(count, bonusCount);
            resultCounts.put(rank, resultCounts.getOrDefault(rank, 0) + 1);
        }
    }

    private Rank rankingLotto(int count, int bonusCount) {
        if (count == 6) {
            return Rank.ONE;
        }
        if (count == 5) {
            if (bonusCount == 1) {
                return Rank.TWO;
            }
            return Rank.THREE;
        }
        if (count == 4) {
            return Rank.FOUR;
        }
        return Rank.FIVE;
    }

    public int totalPrize(Map<Rank, Integer> resultCounts) {
        int sum = 0;
        for (Rank rank : resultCounts.keySet()) {
            if (resultCounts.get(rank) > 0) {
                sum += rank.getAmount() * resultCounts.get(rank);
            }
        }
        return sum;
    }

    public double calculateYieldRate(int sum, int price) {
        return (double) sum / price * 100;
    }
}
