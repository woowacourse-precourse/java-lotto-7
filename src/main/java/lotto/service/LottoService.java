package lotto.service;


import static lotto.constant.LottoConstants.LOTTO_PRICE;
import static lotto.error.ErrorType.INVALID_NUMBER_FORMAT;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoResult;
import lotto.dto.LottoResultDto;
import lotto.error.exception.InvalidNumberFormatException;
import lotto.generator.LottoGenerator;

public class LottoService {
    private final static String WINNING_NUMBER_SEPARATOR = ",";

    public LottoService(final LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    private final LottoGenerator lottoGenerator;

    public int getLottoCountByAmount(int purchaseAmount) {
        LottoCount lottoCount = new LottoCount(purchaseAmount, LOTTO_PRICE);
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
        LottoResult lottoResult = new LottoResult(lottos.size());
        for (Lotto lotto : lottos) {
            int matchCount = lotto.calculateMatchCount(winningLotto);
            boolean isBonusMatched = lotto.isBonusMatched(bonusNumber);
            lottoResult.updateLottoResult(matchCount, isBonusMatched);
        }

        return LottoResultDto.of(lottoResult);
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberFormatException(INVALID_NUMBER_FORMAT);
        }
    }
}
