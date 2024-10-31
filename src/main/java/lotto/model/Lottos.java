package lotto.model;

import static lotto.model.Winning.FIVE;
import static lotto.model.Winning.FIVE_BONUS;
import static lotto.model.Winning.NONE;
import static lotto.model.Winning.fromCount;
import static lotto.model.Winning.values;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class Lottos {
    private Map<Lotto, Winning> lottos = new LinkedHashMap<>();

    public void allocateLottosByRandomNumber(int lottoCount) {
        IntStream.range(0, lottoCount)
                .forEach(i -> lottos.put(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)), NONE));
    }

    public void ascAllLottoNumber() {
        lottos.keySet().forEach(Lotto::ascNumbers);
    }

    public String toStringAllLottoNumber() {
        StringBuilder sb = new StringBuilder();
        lottos.keySet().forEach(lotto -> sb.append(lotto.toString()));
        return sb.toString();
    }

    public void winningByWinningAndBonusNumber(List<Integer> winningNumber, int bonusNumber) {
        lottos.keySet().forEach(lotto -> {
            lottos.put(lotto, fromCount(lotto.confirmWinning(winningNumber)));
            if (lotto.confirmBonus(bonusNumber) && lottos.get(lotto) == FIVE) {
                lottos.put(lotto, FIVE_BONUS);
            }
            lottos.get(lotto).increaseCount();
        });
    }

    public String toStringWinningMessageAndCount() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(values())
                .filter(winning -> winning != NONE)
                .forEach(winning -> sb.append(winning.toStringMessageAndCount()));
        return sb.toString();
    }

    public BigDecimal calculateWinningRate(BigDecimal lottoPrice) {
        AtomicReference<BigDecimal> totalWinningPrice = new AtomicReference<>(BigDecimal.ZERO);
        Arrays.stream(values())
                .filter(winning -> winning != NONE)
                .forEach(winning -> {
                    totalWinningPrice.updateAndGet(p -> p.add(winning.multiplyCount()));
                });
        return totalWinningPrice.get()
                .divide(lottoPrice, 10, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .setScale(1, RoundingMode.HALF_UP)
                .stripTrailingZeros();
    }
}
