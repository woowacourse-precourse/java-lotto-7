package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;

    public List<Lotto> purchaseLotto(int amount){
        validatePurchaseAmount(amount);
        int count = amount / LOTTO_PRICE;
        return generateLottos(count);
    }

    private void validatePurchaseAmount(int amount) {
        if (amount < LOTTO_PRICE){
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 이상이어야 합니다.");
        }
        if (amount % LOTTO_PRICE != 0){
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    private List<Lotto> generateLottos(int count){
        return IntStream.range(0, count)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .collect(Collectors.toList());
    }

    public Map<WinningRank, Integer> calculateWinningStatistics(
            List<Lotto> lottos,
            Lotto winningLotto,
            int bonusNumber){
        return lottos.stream()
                .map(lotto -> lotto.match(winningLotto, bonusNumber))
                .collect(Collectors.groupingBy(
                        rank -> rank,
                        Collectors.collectingAndThen(Collectors.counting(),Long::intValue)
                ));
    }

    public double calculateReturnRate(Map<WinningRank, Integer> statistics, int purchaseAmount) {
        int totalPrize = statistics.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return Math.round((double) totalPrize / purchaseAmount * 1000.0) / 10.0; // 이부분 예상 수익률이 정확하게 계산 체크 테케 작성해보기.
    }

}
