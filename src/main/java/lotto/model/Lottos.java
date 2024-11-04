package lotto.model;

import static java.math.BigDecimal.valueOf;
import static java.math.RoundingMode.HALF_UP;
import static lotto.model.Winning.NONE;
import static lotto.model.Winning.getFromValue;
import static lotto.model.Winning.getTotalWinningPrice;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Lottos {
    public static int WINING_RATE_DECIMAL_PLACE = 1;
    private static int WINNING_RATE_DECIMAL_LIMIT = 10;
    private static int WINNING_RATE_MULTIPLIER = 100;
    private final Map<Lotto, Winning> lottos = new LinkedHashMap<>();

    public Lotto allocateLottosByRandomNumber(List<Integer> randomNumbers, Function<List<Integer>, Lotto> create) {
        Lotto lotto = create.apply(randomNumbers);
        lottos.put(lotto, NONE);
        return lotto;
    }

    public String toStringAllLottoNumber() {
        StringBuilder sb = new StringBuilder();
        lottos.keySet().forEach(lotto -> sb.append(lotto.toString()).append("\n"));
        return sb.toString();
    }

    public int size() {
        return lottos.size();
    }

    public void clear() {
        lottos.clear();
    }

    public Winning getWinning(Lotto lotto) {
        return lottos.get(lotto);
    }

    public void setByCorrectCount(List<Integer> winningNumbers, int bonusNumber) {
        lottos.keySet().forEach(lotto ->
                setByWinningNumber(winningNumbers, bonusNumber, lotto).increaseCount());
    }

    private Winning setByWinningNumber(List<Integer> winningNumbers, int bonusNumber , Lotto lotto) {
        int correctCount = lotto.correctCount(winningNumbers);
        Winning winning = getFromValue(correctCount, lotto.isBonus(bonusNumber));

        lottos.put(lotto, winning);

        return winning;
    }

    public BigDecimal calculateWinningRate(BigDecimal lottoPrice) {
        return getTotalWinningPrice()
                .get()
                .divide(lottoPrice, WINNING_RATE_DECIMAL_LIMIT, HALF_UP)
                .multiply(valueOf(WINNING_RATE_MULTIPLIER))
                .setScale(WINING_RATE_DECIMAL_PLACE, HALF_UP)
                .stripTrailingZeros();
    }
}