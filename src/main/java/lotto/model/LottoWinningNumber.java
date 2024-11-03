package lotto.model;

import lotto.validation.LottoWinningNumberValidator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoWinningNumber {

    private final List<Integer> lottoWinningNumbers;
    private final LottoWinningNumberValidator validator = new LottoWinningNumberValidator();

    public LottoWinningNumber(List<Integer> lottoWinningNumbers) {
        this.lottoWinningNumbers = lottoWinningNumbers;
        validator.validateLengthWinningNumber(lottoWinningNumbers);
        validator.validateDuplicationWinningNumber(lottoWinningNumbers);
    }


}
