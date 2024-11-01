package lotto.service;


import static lotto.constant.Winner.FIFTH_WINNER;
import static lotto.constant.Winner.FIRST_WINNER;
import static lotto.constant.Winner.FOURTH_WINNER;
import static lotto.constant.Winner.SECOND_WINNER;
import static lotto.constant.Winner.THIRD_WINNER;
import static lotto.error.ErrorType.INVALID_NUMBER_FORMAT;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.dto.LottoResultDto;
import lotto.error.exception.InvalidNumberFormatException;
import lotto.generator.LottoGenerator;

public class LottoService {
    private final static String WINNING_NUMBER_SEPARATOR = ",";
    private static final int LOTTO_PRICE = 1000;

    public LottoService(final LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    private final LottoGenerator lottoGenerator;

    public int getLottoCountByAmount(int purchaseAmount) {
        LottoCount lottoCount = new LottoCount(purchaseAmount);
        return lottoCount.getCount();
    }

    public List<Lotto> getLottosByCount(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> Lotto.createRandomNumberLotto(lottoGenerator))
                .toList();
    }

    public Lotto getWinningLotto(String winningNumberInput) {
        List<Integer> numbers = Arrays.stream(winningNumberInput.split(WINNING_NUMBER_SEPARATOR))
                .map(String::trim)
                .map(this::parseInt)
                .toList();
        return Lotto.createFixedNumberLotto(numbers);
    }

    public LottoResultDto getResult(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        Map<Integer, Integer> result = new HashMap<>();
        for (Lotto lotto : lottos) {
            int matchCount = lotto.calculateMatchCount(winningLotto);
            boolean isBonusMatched = lotto.isBonusMatched(bonusNumber);
            updateMatchResult(result, matchCount, isBonusMatched);
        }
        int count = lottos.size();
        double revenue = calculateTotalRevenue(result, count);

        return new LottoResultDto(result, revenue);
    }

    private void updateMatchResult(Map<Integer, Integer> result, int matchCount, boolean isBonusMatched) {
        if (matchCount == FIRST_WINNER.getMatchCount()) {
            int key = FIRST_WINNER.getRank();
            if (isBonusMatched) {
                key = SECOND_WINNER.getRank();
            }
            result.put(key, result.getOrDefault(key, 0) + 1);
        } else if (matchCount == THIRD_WINNER.getMatchCount()) {
            result.put(THIRD_WINNER.getRank(), result.getOrDefault(THIRD_WINNER.getRank(), 0) + 1);
        } else if (matchCount == FOURTH_WINNER.getMatchCount()) {
            result.put(FOURTH_WINNER.getRank(), result.getOrDefault(FOURTH_WINNER.getRank(), 0) + 1);
        } else if (matchCount == FIFTH_WINNER.getMatchCount()) {
            result.put(FIFTH_WINNER.getRank(), result.getOrDefault(FIFTH_WINNER.getRank(), 0) + 1);
        }
    }

    private double calculateTotalRevenue(Map<Integer, Integer> result, int count) {
        double totalRevenue = result.getOrDefault(FIFTH_WINNER.getRank(), 0) * FIRST_WINNER.getPrizeMoney()
                + result.getOrDefault(SECOND_WINNER.getRank(), 0) * SECOND_WINNER.getPrizeMoney()
                + result.getOrDefault(THIRD_WINNER.getRank(), 0) * THIRD_WINNER.getPrizeMoney()
                + result.getOrDefault(FOURTH_WINNER.getRank(), 0) * FOURTH_WINNER.getPrizeMoney()
                + result.getOrDefault(FIFTH_WINNER.getRank(), 0) * FIFTH_WINNER.getPrizeMoney();

        int totalInvest = count * LOTTO_PRICE;
        double rateOfReturn = (totalRevenue / totalInvest) * 100;
        return Math.round(rateOfReturn * 100.0) / 100.0;
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberFormatException(INVALID_NUMBER_FORMAT);
        }
    }
}
