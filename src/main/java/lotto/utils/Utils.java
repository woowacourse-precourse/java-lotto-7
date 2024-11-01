package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class Utils {

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

    public int totalPrize(Map<Rank, Integer> map) {
        int sum = 0;
        for (Rank rank : map.keySet()) {
            if (map.get(rank) > 0) {
                sum += rank.getAmount() * map.get(rank);
            }
        }
        return sum;
    }

    public double calculateYieldRate(int sum, int price) {
        return (double) sum / price;
    }
}
