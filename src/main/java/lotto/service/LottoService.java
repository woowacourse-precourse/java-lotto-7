package lotto.service;

import static lotto.util.Constant.LOTTO_PRICE_UNIT;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import lotto.domain.LotteryBuyer;
import lotto.domain.Lotto;
import lotto.domain.PrizeTier;

public class LottoService {

    private final RandomLottoNumberGenerator randomLottoNumberGenerator;

    public LottoService(RandomLottoNumberGenerator randomLottoNumberGenerator) {
        this.randomLottoNumberGenerator = randomLottoNumberGenerator;
    }

    public LotteryBuyer buyLotto(Integer purchaseAmount) {
        int count = purchaseAmount / LOTTO_PRICE_UNIT;
        List<Lotto> lotteries = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(randomLottoNumberGenerator.generateNumber());
            lotteries.add(lotto);
        }
        return new LotteryBuyer(lotteries);
    }

    public Map<PrizeTier, Long> compareLottoToWinningNumbers(LotteryBuyer lotteryBuyer, List<Integer> winningNumbers,
                                                             int bonusNumber) {
        return lotteryBuyer.getLotteries().stream()
                .map(lotto -> determinePrizeTier(lotto, winningNumbers, bonusNumber))
                .flatMap(Optional::stream)
                .collect(Collectors.groupingBy(prizeTier -> prizeTier, Collectors.counting()));
    }

    private Optional<PrizeTier> determinePrizeTier(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        long matchCount = lotto.getNumbers().stream().filter(winningNumbers::contains).count();
        boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
        return PrizeTier.getPrizeTier((int) matchCount, bonusMatch);
    }

    public double calculateProfitRate(Map<PrizeTier, Long> prizeCounts, int totalPurchaseAmount) {
        long totalWinnings = prizeCounts.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return ((double) totalWinnings / totalPurchaseAmount) * 100;
    }
}
