package lotto.model;

import lotto.validation.LottoWinningNumberValidator;

import java.util.List;

public class LottoWinningNumber {

    private static LottoWinningNumber instance;
    private final List<Integer> lottoWinningNumbers;
    private final LottoWinningNumberValidator validator = new LottoWinningNumberValidator();

    private LottoWinningNumber(List<Integer> lottoWinningNumbers) {
        this.lottoWinningNumbers = lottoWinningNumbers;
        validator.validateLengthWinningNumber(lottoWinningNumbers);
        validator.validateDuplicationWinningNumber(lottoWinningNumbers);
        validator.validateWinningNumber(lottoWinningNumbers);
    }

    public static LottoWinningNumber getInstance(List<Integer> lottoWinningNumbers) {
        if (instance == null) {
            instance = new LottoWinningNumber(lottoWinningNumbers);
        }
        return instance;
    }

    public static List<Integer> getLottoWinningNumbers() {
        return instance.lottoWinningNumbers;
    }
}
