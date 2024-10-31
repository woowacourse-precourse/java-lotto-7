package lotto.service;


import static lotto.exception.ErrorType.INVALID_NUMBER_FORMAT;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.exception.InvalidNumberFormatException;
import lotto.generator.LottoGenerator;

public class LottoService {
    private final static String WINNING_NUMBER_SEPARATOR = ",";

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

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberFormatException(INVALID_NUMBER_FORMAT);
        }
    }
}
