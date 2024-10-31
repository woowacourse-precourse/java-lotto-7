package lotto.service;


import static lotto.exception.ErrorType.INVALID_NUMBER_FORMAT;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.dto.LottoResultDto;
import lotto.exception.InvalidNumberFormatException;
import lotto.generator.LottoGenerator;

public class LottoService {
    private final static String WINNING_NUMBER_SEPARATOR = ",";
    private static final int LOTTO_PRICE = 1000;
    public static final int FIFTH_PRIZE = 5000;
    public static final int FOURTH_PRIZE = 50000;
    public static final int THIRD_PRIZE = 1500000;
    public static final int SECOND_PRIZE = 30000000;
    public static final int FIRST_PRIZE = 2000000000;

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
        if (matchCount == 6) {
            int index = 1;
            if (isBonusMatched) {
                index = 2;
            }
            result.put(index, result.getOrDefault(index, 0) + 1);
        } else if (matchCount == 5) {
            result.put(3, result.getOrDefault(3, 0) + 1);
        } else if (matchCount == 4) {
            result.put(4, result.getOrDefault(4, 0) + 1);
        } else if (matchCount == 3) {
            result.put(5, result.getOrDefault(5, 0) + 1);
        }
    }

    private double calculateTotalRevenue(Map<Integer, Integer> result, int count) {
        double totalRevenue = result.getOrDefault(1, 0) * FIRST_PRIZE
                + result.getOrDefault(2, 0) * SECOND_PRIZE
                + result.getOrDefault(3, 0) * THIRD_PRIZE
                + result.getOrDefault(4, 0) * FOURTH_PRIZE
                + result.getOrDefault(4, 0) * FOURTH_PRIZE
                + result.getOrDefault(5, 0) * FIFTH_PRIZE;

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
