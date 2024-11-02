package lotto.model;

import static java.math.BigDecimal.valueOf;
import static java.math.RoundingMode.HALF_UP;
import static lotto.model.Winning.FIVE;
import static lotto.model.Winning.FIVE_BONUS;
import static lotto.model.Winning.NONE;
import static lotto.model.Winning.getFromValue;
import static lotto.model.Winning.getTotalWinningPrice;
import static lotto.model.Winning.values;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Lottos {
    public static int WINING_RATE_DECIMAL_PLACE = 1;
    private static int WINNING_RATE_DECIMAL_LIMIT = 10;
    private static int WINNING_RATE_MULTIPLIER = 100;
    private final Map<Lotto, Winning> lottos = new LinkedHashMap<>();

    public void allocateLottosByRandomNumber(int lottoCount) {
        IntStream.range(0, lottoCount)
                .forEach(i -> lottos.put(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)), NONE));
    }

    public String toStringAllLottoNumber() {
        StringBuilder sb = new StringBuilder();
        lottos.keySet().forEach(lotto -> sb.append(lotto.toString()).append("\n"));
        return sb.toString();
    }

    public void setByCorrectCount(List<Integer> winningNumber, int bonusNumber) {
        lottos.keySet()
                .forEach(lotto -> setByWinningNumber(winningNumber, bonusNumber, lotto)
                        .increaseCount());
    }

    private Winning setByWinningNumber(List<Integer> winningNumber, int bonusNumber, Lotto lotto) {
        Winning winning = lottos.get(lotto);
        int correctCount = lotto.correctCount(winningNumber);

        lottos.put(lotto, getFromValue(correctCount));

        if (lotto.isBonus(bonusNumber) && winning == FIVE) {
            lottos.put(lotto, FIVE_BONUS);
        }

        return winning;
    }

    public String toStringWinningMessageAndCount() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(values())
                .filter(winning -> winning != NONE)
                .forEach(winning -> sb.append(winning.toStringMessageAndCount()));
        return sb.toString();
    }

    public BigDecimal calculateWinningRate(BigDecimal lottoPrice) {
        return getTotalWinningPrice().get()
                .divide(lottoPrice, WINNING_RATE_DECIMAL_LIMIT, HALF_UP)
                .multiply(valueOf(WINNING_RATE_MULTIPLIER))
                .setScale(WINING_RATE_DECIMAL_PLACE, HALF_UP)
                .stripTrailingZeros();
    }
}
